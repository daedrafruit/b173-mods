//SkinFix ModStart
package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ModRetrieveSkin {

	public static String getSkinURL(String username) {
		String uuid = accessAPI("https://api.mojang.com/users/profiles/minecraft/", username, "id");
		String texturePayload = getTextureResponse(uuid);
		return extractURL(texturePayload, "SKIN");
	}

	public static String getCapeURL(String username) {
		String uuid = accessAPI("https://api.mojang.com/users/profiles/minecraft/", username, "id");
		String texturePayload = getTextureResponse(uuid);
		return extractURL(texturePayload, "CAPE");
	}

	public static String getTextureResponse(String uuid) {
		String base64Value = accessAPI("https://sessionserver.mojang.com/session/minecraft/profile/", uuid, "value");
		byte[] decodedBytes = Base64.getDecoder().decode(base64Value);
		String decodedJson = new String(decodedBytes, StandardCharsets.UTF_8);
		return decodedJson;
	}

	public static String getUUID(String username) {
		String uuid = accessAPI("https://api.mojang.com/users/profiles/minecraft/", username, "id");
		return uuid;
	}

	public static String accessAPI(String baseUrl, String pathParam, String jsonKey) {
		String responseBody = "";
		try {
			URL url = new URL(baseUrl + pathParam);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseBuilder = new StringBuilder();
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					reader.close();
					responseBody = responseBuilder.toString();
					connection.disconnect();
					break;
				}
				responseBuilder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extractValue(responseBody, jsonKey);
	}

	public static String extractValue(String json, String targetKey) {
		String cleanedJson = json.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\s", "").replaceAll("\\]", "");
		String[] pairs = cleanedJson.split(",");
		String[] pairsCopy = pairs;
		int pairCount = pairs.length;
		for (int i = 0; i < pairCount; ++i) {
			String pair = pairsCopy[i];
			String[] keyValue = pair.split(":");
			if (keyValue.length == 2) {
				String key = keyValue[0].replaceAll("\"", "").trim();
				String value = keyValue[1].replaceAll("\"", "").trim();
				if (targetKey.equals(key)) {
					return value;
				}
			}
		}
		return null;
	}

	private static String extractURL(String decodedJson, String textureType) {
		int texturesIndex = decodedJson.indexOf("\"textures\"");
		if (texturesIndex == -1) {
			return null;
		} else {
			int typeIndex = decodedJson.indexOf("\"" + textureType + "\"", texturesIndex);
			if (typeIndex == -1) {
				return null;
			} else {
				int urlKeyIndex = decodedJson.indexOf("\"url\" : \"", typeIndex);
				if (urlKeyIndex == -1) {
					return null;
				} else {
					int urlStart = urlKeyIndex + "\"url\" : \"".length();
					int urlEnd = decodedJson.indexOf("\"", urlStart);
					String url = decodedJson.substring(urlStart, urlEnd);
					String httpsUrl = url.replace("http://", "https://");
					return httpsUrl;
				}
			}
		}
	}
}
//SkinFix ModEnd

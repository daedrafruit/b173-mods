package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ModRetrieveSkin {
	public static String getSkinURL(String var0) {
		String var1 = accessAPI("https://api.mojang.com/users/profiles/minecraft/", var0, "id");
		String var2 = getTextureResponse(var1);
		return extractURL(var2, "SKIN");
	}

	public static String getCapeURL(String var0) {
		String var1 = accessAPI("https://api.mojang.com/users/profiles/minecraft/", var0, "id");
		String var2 = getTextureResponse(var1);
		return extractURL(var2, "CAPE");
	}

	public static String getTextureResponse(String var0) {
		String var1 = accessAPI("https://sessionserver.mojang.com/session/minecraft/profile/", var0, "value");
		byte[] var2 = Base64.getDecoder().decode(var1);
		String var3 = new String(var2, StandardCharsets.UTF_8);
		return var3;
	}

	public static String getUUID(String var0) {
		String var1 = accessAPI("https://api.mojang.com/users/profiles/minecraft/", var0, "id");
		return var1;
	}

	public static String accessAPI(String var0, String var1, String var2) {
		String var3 = "";

		try {
			URL var4 = new URL(var0 + var1);
			HttpURLConnection var5 = (HttpURLConnection)var4.openConnection();
			var5.setRequestMethod("GET");
			BufferedReader var6 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
			StringBuilder var8 = new StringBuilder();

			while(true) {
				String var7 = var6.readLine();
				if(var7 == null) {
					var6.close();
					var3 = var8.toString();
					var5.disconnect();
					break;
				}

				var8.append(var7);
			}
		} catch (Exception var9) {
			var9.printStackTrace();
		}

		return extractValue(var3, var2);
	}

	public static String extractValue(String var0, String var1) {
		String var2 = var0.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\s", "").replaceAll("\\]", "");
		String[] var3 = var2.split(",");
		String[] var4 = var3;
		int var5 = var3.length;

		for(int var6 = 0; var6 < var5; ++var6) {
			String var7 = var4[var6];
			String[] var8 = var7.split(":");
			if(var8.length == 2) {
				String var9 = var8[0].replaceAll("\"", "").trim();
				String var10 = var8[1].replaceAll("\"", "").trim();
				if(var1.equals(var9)) {
					return var10;
				}
			}
		}

		return null;
	}

	private static String extractURL(String var0, String var1) {
		int var2 = var0.indexOf("\"textures\"");
		if(var2 == -1) {
			return null;
		} else {
			int var3 = var0.indexOf("\"" + var1 + "\"", var2);
			if(var3 == -1) {
				return null;
			} else {
				int var4 = var0.indexOf("\"url\" : \"", var3);
				if(var4 == -1) {
					return null;
				} else {
					int var5 = var4 + "\"url\" : \"".length();
					int var6 = var0.indexOf("\"", var5);
					String var7 = var0.substring(var5, var6);
					String var8 = var7.replace("http://", "https://");
					return var8;
				}
			}
		}
	}
}

package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ModConfig {
	private Properties properties = new Properties();

	public ModConfig(String fileName, String body) {
		try {
			File file = new File(fileName);
			if(!file.exists()) {
				this.createDefaultConfig(file, body);
			}

			FileInputStream input = new FileInputStream(fileName);
			this.properties.load(input);
			input.close();
		} 
    catch (IOException exception) {
			exception.printStackTrace();
			System.err.println("Error handling the configuration file: " + exception.getMessage());
		}

	}

	private void createDefaultConfig(File file, String body) throws IOException {
		file.createNewFile();
		FileWriter writer = null;

		try {
			writer = new FileWriter(file);
			writer.write(body);
		} finally {
			if(writer != null) {
				writer.close();
			}

		}

	}

	public String getProperty(String property) {
		return this.properties.getProperty(property, "0");
	}
}

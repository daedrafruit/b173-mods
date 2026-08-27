package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ModConfig {
	private Properties properties = new Properties();

	public ModConfig(String var1, String var2) {
		try {
			File var3 = new File(var1);
			if(!var3.exists()) {
				this.createDefaultConfig(var3, var2);
			}

			FileInputStream var4 = new FileInputStream(var1);
			this.properties.load(var4);
			var4.close();
		} catch (IOException var5) {
			var5.printStackTrace();
			System.err.println("Error handling the configuration file: " + var5.getMessage());
		}

	}

	private void createDefaultConfig(File var1, String var2) throws IOException {
		var1.createNewFile();
		FileWriter var3 = null;

		try {
			var3 = new FileWriter(var1);
			var3.write(var2);
		} finally {
			if(var3 != null) {
				var3.close();
			}

		}

	}

	public String getProperty(String var1) {
		return this.properties.getProperty(var1);
	}
}

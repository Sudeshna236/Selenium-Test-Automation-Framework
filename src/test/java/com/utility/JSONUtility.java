package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Environment;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.environment;




public class JSONUtility {

	public static environment readJSON(Environment  env) {
		Gson gson = new Gson();
		File jsonFile =new File(System.getProperty("user.dir")+"\\Config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Config config=gson.fromJson(fileReader, Config.class);
		environment environment =config.getEnvironments().get("QA");
		return environment;

	}

}

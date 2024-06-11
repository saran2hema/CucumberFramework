package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class DataUtils {


	public static String readLoginTestData(String key) throws IOException {

		FileInputStream f=new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p=new Properties();

		p.load(f);
		//f.close();

		return p.getProperty(key);
	}
	public static String readAccountsTestData(String key) throws IOException {

		FileInputStream f=new FileInputStream(FileConstants.ACCOUNTS_TESTDATA_FILE_PATH);
		Properties p=new Properties();

		p.load(f);
		//f.close();

		return p.getProperty(key);
	}
	public static void closeFile() {
		
	}

}

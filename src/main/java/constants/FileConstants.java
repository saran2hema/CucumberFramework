package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH=
			System.getProperty("user.dir")+"/src/main/java/testdata/loginTestData.properties";
	public static final String ACCOUNTS_TESTDATA_FILE_PATH=
			System.getProperty("user.dir")+"/src/main/java/testdata/createAccountTestData.properties";
	public static final String SCREENSHOT_FILE_PATH=
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".PNG";
	public static final String REPORT_PATH = 
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".html";
	
	

}

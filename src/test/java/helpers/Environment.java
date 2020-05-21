package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

	
	private String appURL;	
	
	public Environment(String env) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream systemInput;
		systemInput=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\environmentDetails.properties");
		prop.load(systemInput);
		setURL(prop.getProperty(env+".URL"));
		
	}	

	public String getURL(){
		return appURL;
	}
	public void setURL(String url) {
		this.appURL = url;
	}
	
}

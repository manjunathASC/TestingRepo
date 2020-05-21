package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSelect {
	private static WebDriver driver;
	private static Properties prop=new Properties();
	private static FileInputStream systemInput;
	private static String DriverPath;	

	public static WebDriver setup(String browserName) throws IOException {
		systemInput=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\environmentDetails.properties");
		prop.load(systemInput);

		if (browserName.equalsIgnoreCase("Chrome")) {
			
			DriverPath=prop.getProperty("CHROMEDRIVER_PATH");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+DriverPath);
			
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
		//	chromePrefs.put("download.default_directory", System.getProperty("user.dir")+downloadPath);
			
				
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");		
							
			@SuppressWarnings("static-access")
			DesiredCapabilities chromeCapability = new DesiredCapabilities().chrome();
			chromeCapability.setJavascriptEnabled(true);
			//chromeCapability.setBrowserName("chrome");
			//chromeCapability.setPlatform(Platform.WINDOWS);
			chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeCapability.setCapability("profile.default_content_settings.popups", 0);	
		
			driver = new ChromeDriver(chromeCapability);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+DriverPath);
			FirefoxProfile firefoxProfile = new FirefoxProfile();

			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference(
					"browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force",
					false);
			firefoxProfile
					.setPreference(
							"browser.helperApps.neverAsk.saveToDisk",
							"application/msword,application/csv,text/csv,application/vnd.ms-excel,application/pdf");
			firefoxProfile.setPreference("pdfjs.disabled", true);
			firefoxProfile.setPreference("xlsjs.disabled", true);
			firefoxProfile.setPreference("csvjs.disabled", true);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+DriverPath);
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capabilities.setCapability("requireWindowFocus", true);
			
			File file = new File(
					"C:\\NotBackedUp\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	}


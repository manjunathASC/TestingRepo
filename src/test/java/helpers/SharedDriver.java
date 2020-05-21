package helpers;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Date;


public class SharedDriver {
	
	private static WebDriver REAL_DRIVER;
	private static boolean initialized = false;

	Date date=new Date();
	
    static {
    	  
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
				  	REAL_DRIVER.close();
		            REAL_DRIVER.quit();
					Log.info("Driver is closed");
				} catch (Exception e) {
					Log.error("Driver is closed in Exception , Driver Instance :" + REAL_DRIVER + "Ex. Message:"
							+ e.getMessage());
				}
			}
		});

    }

    public SharedDriver(String browser) throws IOException {

    	if(!initialized){

    		Log.info("*********************Test Excecution Started on "+date+"************************");
    		Log.info("Inside shared driver init.....");
    		REAL_DRIVER = BrowserSelect.setup(browser);
    		REAL_DRIVER.manage().deleteAllCookies();
        	REAL_DRIVER.manage().window().maximize();
    		initialized = true;
    		
    	}

    }
    
    public WebDriver getDriver(){    	
    	return REAL_DRIVER;
    }
    
}

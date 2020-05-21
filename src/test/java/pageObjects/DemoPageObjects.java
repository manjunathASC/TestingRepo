package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoPageObjects {

	@FindBy(how=How.CLASS_NAME, using="tp-bgimg defaultimg")
	public WebElement homepage;
	
	@FindBy(how=How.XPATH, using="//nav[@class='navigation']/ul/li[2]/a/span/span")
	public WebElement tutorial;
	
	
	@FindBy(how=How.XPATH, using="//nav[@class='navigation']/ul/li[2]/ul/li/a/span/span")
	public List<WebElement> tutorialSubList;
	
	
	@FindBy(how=How.XPATH, using="//nav[@class='navigation']/ul/li[3]/a/span/span")
	public WebElement seleniumTraining;
	
	@FindBy(how=How.XPATH, using="//nav[@class='navigation']/ul/li[7]/a/span/span")
	public WebElement about;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/div[1]/div[2]/div/div/div/div/h2/span/em")
	public WebElement cucumberTxt;
	
}

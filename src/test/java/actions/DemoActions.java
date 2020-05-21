package actions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

import pageObjects.DemoPageObjects;
import utilities.GetScreenShot;

public class DemoActions {

	WebDriver driver;
	WebDriverWait wait;
	DemoPageObjects demoPO;
	GetScreenShot screenshot;
	
	public DemoActions(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 60);
		screenshot = new GetScreenShot();
		demoPO=PageFactory.initElements(driver, DemoPageObjects.class);	
	}
	
	public void clickL1Menu(String l1menu,String l2menu,String scenarioName) throws IOException, Exception
	{
		System.out.println(l1menu);
		System.out.println(l2menu);
		int count=0;
		List<WebElement> lweb=demoPO.tutorialSubList;
		System.out.println(lweb.size());
		for(int i=0;i<lweb.size();i++)
		{
			System.out.println(lweb.get(i).getText());
			if(lweb.get(i).getText().trim().equals(l1menu.trim()))
			{
				count=i+1;
				break;
			}
		}
		System.out.println(count);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation']/ul/li[2]/ul/li["+(count)+"]"))).build().perform();
	    Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
		clickL2Menu(count, l2menu);
	}
	
	public void clickL2Menu(int count, String l2select) {
		List<WebElement> l2list=driver.findElements(By.xpath("//nav[@class='navigation']/ul/li[2]/ul/li["+(count)+"]/ul/li/a/span/span"));
		System.out.println(l2list.size());
		for(int i=0;i<l2list.size();i++)
		{
			System.out.println(l2list.get(i).getText());
			if(l2list.get(i).getText().trim().equals(l2select.trim()))
			{
				l2list.get(i).click();
				break;
			}
		}	
	}
}

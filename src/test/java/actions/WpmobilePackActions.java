package actions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

import helpers.FeatureData;
import pageObjects.DemoPageObjects;
import pageObjects.WpmobilePackPageObjects;
import utilities.GetScreenShot;

public class WpmobilePackActions {

	private int exact;
	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement element;
	DemoPageObjects demoPO;
	GetScreenShot screenshot;
	WpmobilePackPageObjects wpPO;
	
	public WpmobilePackActions(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 60);
		screenshot = new GetScreenShot();
		demoPO=PageFactory.initElements(driver, DemoPageObjects.class);	
		wpPO=PageFactory.initElements(driver, WpmobilePackPageObjects.class);	
	}
	
	public String getPrice(String item) throws IOException, Exception
	{	
	    exact=homeitemsMethod(item);
		element=wpPO.homeGrid.findElement(By.xpath("//div["+(exact)+"]/div[1]/div/div[2]/h3/div"));
		return element.getText();
	}
	
	public int homeitemsMethod(String item) {
		int count=0;
		List<WebElement> lweb=wpPO.homeItems;
		System.out.println(lweb.size());
		for(int i=0;i<lweb.size();i++)
		{
			System.out.println(lweb.get(i).getText());
			if(lweb.get(i).getText().trim().equals(item.trim()))
			{
				count=i+2;
				break;
			}
		}
		System.out.println(count);
		return count;
	}
	
	public void shopClick(String item) {
		 exact=homeitemsMethod(item);
		 element=wpPO.homeGrid.findElement(By.xpath("//div["+(exact)+"]/div[2]/a"));
		 element.click();
	}
	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void fillTheFields(List<FeatureData> data,String scenarioName) throws IOException, Exception
	{
		wpPO.firstName.clear();
		wpPO.firstName.sendKeys(data.get(0).firstName);
		wpPO.lastName.clear();
		wpPO.lastName.sendKeys(data.get(0).lastName);
		wpPO.company.clear();
		wpPO.company.sendKeys(data.get(0).companyName);
		wpPO.country.click();
		wpPO.countryTxtField.sendKeys(data.get(0).country);
		wpPO.countrySelect.click();
		wpPO.address1.clear();
		wpPO.address1.sendKeys(data.get(0).address1);
		wpPO.address2.clear();
		wpPO.address2.sendKeys(data.get(0).address2);
		wpPO.city.clear();
		wpPO.city.sendKeys(data.get(0).city);
		wpPO.state.click();
		wpPO.countryTxtField.sendKeys(data.get(0).country);
		wpPO.countrySelect.click();
		wpPO.postCode.clear();
		wpPO.postCode.sendKeys(data.get(0).zip);
		wpPO.phone.clear();
		wpPO.phone.sendKeys(data.get(0).phoneNumber);
		wpPO.email.clear();
		wpPO.email.sendKeys(data.get(0).email);
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
	}
	public void addSelectedProduct(String scenarioName) throws IOException, Exception {
		wpPO.addCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(wpPO.notificationMsg));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
		wpPO.cartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(wpPO.checkout));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
		wpPO.checkout.click();
		wait.until(ExpectedConditions.visibilityOf(wpPO.firstName));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
	}
	
	public void selectProduct(String product,String scenarioName) throws IOException, Exception {
		shopClick(product);
		wait.until(ExpectedConditions.visibilityOf(wpPO.addCartBtn));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
		Thread.sleep(1000);
	}
	
	public void orderPlaced(String orderExp,String scenarioName) throws IOException, Exception
	{
		
				wpPO.orderBtn.click();
				wait.until(ExpectedConditions.visibilityOf(wpPO.orderReceived));
				Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName)); 
				Assert.assertTrue(orderExp.trim().equals(wpPO.orderReceived.getText().trim()));
	}
}

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WpmobilePackPageObjects {

	@FindBy(how=How.XPATH, using="//div[@class='infinite-scroll-component']//div[@class='ui grid']/div/div[1]")
	public  List<WebElement> homeItems;
	
	@FindBy(how=How.XPATH, using="//div[@class='infinite-scroll-component']/div")
	public  WebElement homeGrid;
	
	@FindBy(how=How.XPATH, using="//div[@class='top-center']/span/div/div/div[2]/div[2]")
	public  WebElement notificationMsg;
	
	@FindBy(how=How.XPATH, using="//header[@class='entry-header']/h1")
	public  WebElement orderReceived;
	
	@FindBy(how=How.XPATH,using="//*[@id='root']/div/div/div[2]/div[2]/div[2]/button")
	public  WebElement addCartBtn;
	
	@FindBy(how=How.CLASS_NAME,using="icons")
	public  WebElement cartBtn;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	public  WebElement checkout;
	
	@FindBy(how=How.ID,using="billing_first_name")
	public  WebElement firstName;
	
	@FindBy(how=How.ID,using="billing_last_name")
	public  WebElement lastName;
	
	@FindBy(how=How.ID,using="billing_company")
	public  WebElement company;
	
	@FindBy(how=How.ID,using="select2-billing_country-container")
	public  WebElement country;
	
	@FindBy(how=How.CLASS_NAME,using="select2-search__field")
	public  WebElement countryTxtField;
	
	@FindBy(how=How.XPATH,using="//ul[@class='select2-results__options']/li[1]")
	public  WebElement countrySelect;
	
	@FindBy(how=How.ID,using="billing_address_1")
	public  WebElement address1;
	
	@FindBy(how=How.ID,using="billing_address_2")
	public  WebElement address2;
	
	@FindBy(how=How.ID,using="billing_city")
	public  WebElement city;
	
	@FindBy(how=How.ID,using="select2-billing_state-container")
	public  WebElement state;
	
	@FindBy(how=How.ID,using="billing_postcode")
	public  WebElement postCode;
	
	@FindBy(how=How.ID,using="billing_phone")
	public  WebElement phone;
	
	@FindBy(how=How.ID,using="billing_email")
	public  WebElement email;
	
	@FindBy(how=How.XPATH,using="//*[@id='place_order']")
	public  WebElement orderBtn;
}

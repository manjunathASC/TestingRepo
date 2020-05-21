package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

import actions.DemoActions;
import actions.WpmobilePackActions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Environment;
import helpers.SharedDriver;
import pageObjects.DemoPageObjects;
import pageObjects.WpmobilePackPageObjects;
import utilities.GetScreenShot;

public class ToolsqaStepDefinition {

	public static final String BROWSER="Chrome"; //values Chrome,FireFox,IE
	public static String env="ToolsQA";
	public static WebDriver driver;
	static String scenarioName;
	GetScreenShot screenshot;
	DemoPageObjects demoPO;
	WpmobilePackPageObjects wpPO;
	DemoActions demoA;
	WpmobilePackActions wpAction;
	SharedDriver shdriver;
	WebDriverWait wait;
	Environment environment;

	@Before
	public void browserLaunch(Scenario scenario) throws Exception {	

		System.out.println("Before scenario------------------excecuted");
		shdriver = new SharedDriver(BROWSER);
		driver = shdriver.getDriver();
		System.out.println("printing driver "+driver);
		screenshot = new GetScreenShot();
		scenarioName=scenario.getName();
		environment=new Environment(env);
		wait=new WebDriverWait(driver, 20);

		demoA = new DemoActions(driver);
		wpAction=new WpmobilePackActions(driver);
		demoPO=new DemoPageObjects();
		wpPO=new WpmobilePackPageObjects();

		demoPO = PageFactory.initElements(driver, DemoPageObjects.class);
		wpPO = PageFactory.initElements(driver, WpmobilePackPageObjects.class);

	}
	@Given("^i aunthorized user able to access toolsqa site$")
	public void i_aunthorized_user_able_to_access_toolsqa_site() throws Throwable {
		driver.get(environment.getURL());
		wait.until(ExpectedConditions.visibilityOf(demoPO.tutorial));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
	}

	@When("^im at home page and navigate to tutorials menu$")
	public void im_at_home_page_and_navigate_to_tutorials_menu() throws Throwable {
		Actions act=new Actions(driver);
		act.moveToElement(demoPO.tutorial).build().perform();
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
	}


	@Then("^navigate to \"([^\"]*)\" menu followed by \"([^\"]*)\"$")
	public void navigate_to_menu_followed_by(String l1menu, String l2menu) throws Throwable {
		demoA.clickL1Menu(l1menu, l2menu, scenarioName);
		wait.until(ExpectedConditions.visibilityOf(demoPO.cucumberTxt));
		Reporter.addScreenCaptureFromPath(screenshot.capture(driver, scenarioName));
	}
	
}

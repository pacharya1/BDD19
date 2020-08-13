package steps;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.BasePage;
import page.DashBoardPage;
import page.LoginPage;
import util.Assertion;
import util.BrowserFactory;
import util.Database;

public class LoginSteps extends BasePage {

    WebDriver driver;
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	Database database;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.init();
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
	}

	@Given("^I am on techfios site$")
	public void i_am_on_techfios_site()  {
		
	}

	@When("^I enter user name and password$")
	public void i_enter_user_name_and_password() throws ClassNotFoundException, SQLException, InterruptedException {
	   loginpage.enterusername(Database.get("username"));
	   loginpage.enterpassword(Database.get("password"));
	   Thread.sleep(3000);
	}

	@When("^I click on sign in button$")
	public void i_click_on_sign_in_button()  {
		loginpage.clickSignInButton();
	  
	}

	@Then("^Dashboard page should display$")
	public void dashboard_page_should_display()  {
	   String expected = "Dashboard- iBilling";
	   Assertion.equals("Page not found", dashboardpage.getPageTitle() , expected);
	}


	
	@After
	public static void afterRun() {
		BrowserFactory.tearDown();
	}
}

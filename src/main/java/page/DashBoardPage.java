package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage extends BasePage {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;

	}

// Element Library

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_ELEMENT_FIELD;

	// Methods to interact with the elements
	public void verifyDashBoardElement() {
		DASHBOARD_ELEMENT_FIELD.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}

package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {

	private WebDriver driver;
	private WebDriverManager webDriverManager;

	public loginStepDefinition(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
		this.driver = webDriverManager.getDriver();
	}

	@Given("I am a user opening home page of Salesforce web application")
	public void i_am_a_user_opening_home_page_of_salesforce_web_application() {
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
	}

	@When("I click on usernametextField")
	public void i_click_on_usernametext_field() {
		driver.findElement(By.id("username")).click();
	}

	@Then("I validate the UNTF is enabled")
	public void i_validate_the_untf_is_enabled() {
		Assert.assertTrue((driver.findElement(By.id("username")).isEnabled()));
	}

	@When("I enter username {string} and I enter password {string}")
	public void i_enter_username_and_i_enter_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']")));

		String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='error']")).getText();

		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
}

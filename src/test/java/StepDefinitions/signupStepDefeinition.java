package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signupStepDefeinition {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private WebDriverWait wait;

    public signupStepDefeinition(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I click on Try For Free button")
    public void i_click_on_try_for_free_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='signup_link']"))).click();
    }

    @Then("I verify sign up page is displayed")
    public void i_verify_sign_up_page_is_displayed() {
        WebElement signUpPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='start-your-free-trial-today']/span")));
        Assert.assertTrue(signUpPageElement.isDisplayed());
    }

    @When("I enter the name {string}")
    public void i_enter_the_name(String name) {
       WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName")));
       nameField.sendKeys(name);
    }

    @When("I enter the surname {string}")
    public void i_enter_the_surname(String suraname) {
        WebElement surnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserLastName")));
        surnameField.sendKeys(suraname);
    }

    @When("I enter the email address {string}")
    public void i_enter_the_email_address(String emailAddress) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserEmail-anfC")));
        emailField.sendKeys(emailAddress);
    }

    @When("I select the employee from dropdown")
    public void i_select_the_employee_from_dropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CompanyEmployees-23X5")));
        Select s = new Select(dropdown);
        s.selectByIndex(1);
    }

    @When("I click on signup button")
    public void i_click_on_signup_button() {
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='start my free trial']")));
        signupButton.click();
    }

    @Then("I validate that the error message should displayed")
    public void i_validate_that_the_error_message_should_displayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='warning-img'])[1]")));
        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println("error image get displayed.....!!");
    }

}

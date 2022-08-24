import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver;
    @Given("User visited to the ecommerce site")
    public void user_visited_to_the_ecommerce_site() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--headed"); //uncomment if you want to run in headless mode
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
    }
    @When("User inputs the valid {string} and {string}")
    public void user_inputs_the_valid_and(String username, String password) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin(username,password);
    }
    @Then("User can login successfully")
    public void user_can_login_successfully() {
        LoginPage loginPage=new LoginPage(driver);
        Assert.assertTrue(loginPage.btnLogout.isDisplayed());
        loginPage.btnLogout.click();
        driver.close();
    }

}

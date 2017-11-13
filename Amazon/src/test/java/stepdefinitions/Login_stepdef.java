package stepdefinitions;

import Utils.Hooks;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Login_stepdef  {

     public static WebDriver driver;

    @Before
    public void open()
    {
        System.out.println("opening the browser");
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");

    }
    @Given("^user should be on Amazon home page$")
    public void userShouldBeOnAmazonHomePage() throws Throwable {

    }

    @When("^user clicks the \"([^\"]*)\" link$")
    public void userClicksTheLink(String signin) throws Throwable {
        driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")).click();

    }

    @And("^user clicks  \"([^\"]*)\" link$")
    public void userClicksLink(String link) throws Throwable {
        driver.findElement(By.id("createAccountSubmit")).click();
    }

    @And("^user enters the name and email$")
    public void userEntersTheNameAndEmail() throws Throwable {
        driver.findElement(By.id("ap_customer_name")).sendKeys("krishna");
        Random r = new Random();
        int val = r.nextInt();
        driver.findElement(By.id("ap_email")).sendKeys("kkmadhuri" + val + "@gmail.com");
    }

    @And("^user enters the password and confirm password$")
    public void userEntersThePasswordAndConfirmPassword() throws Throwable {

        driver.findElement(By.id("ap_password")).sendKeys("dhruvin2009");
        driver.findElement(By.id("ap_password_check")).sendKeys("dhruvin2009");

    }

    @And("^user clicks the Create your Amazon account button$")
    public void userClicksTheCreateYourAmazonAccountButton() throws Throwable {
        driver.findElement(By.id("continue")).click();
    }

    @Then("^user can successfully create an Amazon account with \"([^\"]*)\"$")
    public void userCanSuccessfullyCreateAnAmazonAccountWith(String text) throws Throwable {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(text));
    }

    @When("^user clicks the \"([^\"]*)\" link from homepage$")
    public void userClicksTheLinkFromHomepage(String arg0) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]")).click();

    }

    @And("^user enters the email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userEntersTheEmailAndPassword(String name, String email) throws Throwable {
        driver.findElement(By.id("ap_email")).sendKeys(name);
        driver.findElement(By.id("ap_password")).sendKeys(email);
    }

    @And("^user clicks the sign_in button$")
    public void userClicksTheSign_inButton() throws Throwable {
        driver.findElement(By.id("signInSubmit")).click();

    }

    @Then("^user can successfully signin$")
    public void userCanSuccessfullySignin() throws Throwable {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Hello, krish"));

    }


    @And("^user should signoff$")
    public void userShouldSignoff() throws Throwable {
        Actions action = new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[2]"));
        action.moveToElement(element).click().perform();

        driver.findElement(By.linkText("Not krish? Sign Out" )).click();

    }

     @After
    public  void close()
    {
        driver.quit();
    }
}
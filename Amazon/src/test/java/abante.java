import Utils.Hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class abante extends Hooks {
    @Test
    public void test()throws InterruptedException
    {
        driver.navigate().to("http://demos1.softaculous.com/AbanteCart/");
        driver.findElement(By.id("filter_keyword")).click();
        driver.findElement(By.xpath(".//*[@id='category_68']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='search_form']/div/div/i")).click();
        driver.findElement(By.id("keyword")).sendKeys("T-shirt");
        WebElement ele=driver.findElement(By.id("category_id"));
        Select dropdown=new Select(ele);
        dropdown.selectByValue("0,68,70");
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("search_button")).click();
       // driver.findElement(By.xpath(".//*[@id='maincontainer']/div/div[1]/div/ul/li/a/a")).click();
        WebElement element1=driver.findElement(By.id("sort"));
        Select dropdown1=new Select(element1);
        dropdown1.selectByVisibleText("Price Low > High");
        driver.findElement(By.xpath(".//*[@id='maincontainer']/div/div/div/div/div[3]/div[1]/div[1]/div/a")).click();
        WebElement element3= driver.findElement(By.id("option349"));
        Select size=new Select(element3);
        size.selectByValue("772");
        WebElement element4=driver.findElement(By.id("product_quantity"));
        element4.clear();
        element4.sendKeys("2");
        driver.findElement(By.className("cart")).click();
        driver.findElement(By.id("cart_checkout1")).click();


    }
    @Test

    public void test1()throws InterruptedException
    {   driver.navigate().to("http://demos1.softaculous.com/AbanteCart/");
        driver.findElement(By.xpath(".//*[@class='facebook']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("AbanteCart"));



    }
//    Scenario: Newsletter Signup
//    When User clicks the subscribe button
//    And User enters the FirstName,LastName and email
//    And user entered the displayed code over there
// # And User clicks the continue
//    //scenario: Newletter signup

//    @When("^User clicks the subscribe button$")
//    public void userClicksTheSubscribeButton() throws Throwable {
//        driver.findElement(By.xpath(".//*[@class='btn btn-orange']")).click();
//    }
//    @And("^User enters the FirstName,LastName and email$")
//    public void userEntersTheFirstNameLastNameAndEmail() throws Throwable {
//        driver.findElement(By.id("SubscriberFrm_firstname")).sendKeys("Dhruv");
//        driver.findElement(By.id("SubscriberFrm_lastname")).sendKeys("koti");
//        driver.findElement(By.id("SubscriberFrm_email")).sendKeys("kk.mas"+val+"@gmail.com");
//
//    }
//    @And("^user entered the displayed code over there$")
//    public void userEnteredTheDisplayedCodeOverThere() throws Throwable {
//        WebElement ele= driver.findElement(By.tagName("img"));
//        WebElement element=driver.findElement(By.xpath(".//*[@id='SubscriberFrm']//div//img"));
//        //System.out.println(element.hashCode());
//        String st=element.getText();//*[@id='SubscriberFrm']/div/fieldset/div[5]/div/span/img
//        System.out.println("text:"+st);
//    }

}

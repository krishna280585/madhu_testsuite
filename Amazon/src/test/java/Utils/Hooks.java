package Utils;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
 @BeforeClass
  public static void openBrowser()
  {
      if(AutomationConstrants.BROWSER.equalsIgnoreCase("chrome"))
      {
          System.out.println("opening the browser");
          System.setProperty("webdriver.chrome.driver","chromedriver");
          driver=new ChromeDriver();

      }
      else if(AutomationConstrants.BROWSER.equalsIgnoreCase("firefox"))
      {
          System.out.println("opening the browser");
          System.setProperty("webdriver.gecko.driver","geckodriver");
          driver=new FirefoxDriver();
      }
      else {
          Assert.fail("Not a valid Browser");

      }
      driver.get(AutomationConstrants.URL);
      driver.manage().timeouts().implicitlyWait(AutomationConstrants.MAX_TIMEOUT, TimeUnit.SECONDS);

  }

  @AfterClass
    public static void closeBrowser()
  {
      System.out.println("Closing The Browser");
      //driver.quit();
  }
}

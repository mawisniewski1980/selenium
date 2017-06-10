package testobject;

import java.util.concurrent.TimeUnit;

import org.fest.assertions.api.Fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

import enums.PageUrls.PageUrl;
import utilsobjects.OUtils;
import webdriverobjects.OWebDriver;

public class TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(TestObject.class.getName());

  private OWebDriver webDriver = new OWebDriver(BrowserName.CHROME);
  protected WebDriver driver = OWebDriver.getDriver();
  protected OUtils utils = new OUtils();

  @Rule
  public TestName testName = new TestName();

  @Before
  public void setUpBeforeClass() {
    if (driver == null) {
      Fail.fail("Driver cannot be null");
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    System.out.println("#####################################  START " + utils.startDate() + " #####################################");
  }

  @After
  public void tearDownAfterClass() {
    // utils.takeScreenShoot("STOP_" + testName.getMethodName());
    driver.manage().deleteAllCookies();
    driver.quit();
    System.out.println("#####################################  STOP " + utils.endDate() + " ######################################");
    System.out.println("Quit webdriver");
  }

  protected void setUrl(PageUrl url) {

    switch (url) {
    case DEMOQA: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case ONET: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case FULLCALENDAR: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case ORANGEHRM: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_ADMIN: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_DEMO: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_SUPPLIER: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_USER: {
      System.out.println("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    default: {
      LOG.info("No Url !");
      Fail.fail("No Url !");
      break;
    }
    }
  }
}

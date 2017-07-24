package testobject;

import enums.PageUrls.PageUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;


import utilsobjects.OLogs;
import utilsobjects.OUtils;
import webdriverobjects.OWebDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class OTest {

  private static final Logger LOG = LogManager.getLogger("OTest");

  protected WebDriver driver = OWebDriver.getOWebDriverInstance().initChromeBrowser();
  protected OUtils utils = new OUtils(driver);

  @Rule
  public OTestRules rules = new OTestRules(utils.logs);

  @Before
  public void setUpBeforeClass() {
  if (driver == null) {
      LOG.error("Driver cannot be null");
      fail("Driver cannot be null");
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @After
  public void tearDownAfterClass() {

  }

  protected void setUrl(PageUrl url) {

    switch (url) {
    case DEMOQA: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case ONET: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case FULLCALENDAR: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case ORANGEHRM: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_ADMIN: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_DEMO: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_SUPPLIER: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    case PHPTRAVELS_USER: {
      LOG.info("Open Url: " + url.getAddress());
      driver.navigate().to(url.getAddress());
      break;
    }

    default: {
      LOG.error("No Url !");
      fail("No Url !");
      break;
    }
    }
  }
}

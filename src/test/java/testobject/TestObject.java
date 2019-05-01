package testobject;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilsobjects.Utils;
import webdriverobjects.WebDriverObject;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.fail;

public abstract class TestObject {

  protected Logger logger = LoggerFactory.getLogger(getClass());

  protected WebDriver driver = WebDriverObject.getInstance().initChromeBrowser();
  protected Utils utils = new Utils(driver);


  @BeforeClass
  public void setUpBeforeClass() {

    if (driver == null) {
      logger.error("Driver cannot be null");
      fail("Driver cannot be null");
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @AfterClass
  public void tearDownAfterClass() {
    driver.manage().deleteAllCookies();
    driver.quit();
  }

}

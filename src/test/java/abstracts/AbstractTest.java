package abstracts;

import factories.SimplePageFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import tools.Property;
import tools.WebDriverInit;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.fail;

public abstract class AbstractTest {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractTest.class);

  private WebDriver driver = WebDriverInit.INSTANCE.initChromeBrowser();
  protected SimplePageFactory factory = SimplePageFactory.INSTANCE.setDriver(driver);

  @BeforeSuite
  public void beforeSuite(){
    LOG.info("Starting tests...");
  }

  @AfterSuite
  public void afterSuite(){
    LOG.info("Stopping tests...");
  }

  @BeforeClass
  public void beforeClass() {

    if (driver == null) {
      fail("Driver cannot be null");
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
    driver.manage().deleteAllCookies();
    driver.close();
    driver.quit();
  }

  protected void openUrl() {
    String url = Property.INSTANCE.getPropertyValue("pageUrl");
    LOG.info("Opening page {}", url);
    driver.navigate().to(url);
  }

}

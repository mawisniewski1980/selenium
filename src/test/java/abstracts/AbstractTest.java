package abstracts;

import factories.SimplePageFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tools.Property;
import tools.WebDriverInit;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.fail;

public abstract class AbstractTest {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractTest.class);

  private WebDriver   driver = WebDriverInit.INSTANCE.initChromeBrowser();
  protected SimplePageFactory factory = SimplePageFactory.INSTANCE.setDriver(driver);

  @BeforeClass
  public void setUpBeforeClass() {



    if (driver == null) {
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
    driver.close();
  }

  protected void openUrl() {
    String url = Property.INSTANCE.getPropertyValue("pageUrl");
    LOG.info("Opening page {}", url);
    driver.navigate().to(url);
  }

}

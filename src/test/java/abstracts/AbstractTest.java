package abstracts;

import factories.FactoryPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.NavigationPage;
import tools.Property;
import tools.WebDriverInit;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.fail;

public abstract class AbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;
    protected FactoryPage factory;
    protected NavigationPage navigation;

    public AbstractTest() {
        driver = new WebDriverInit().initChromeBrowser();
        factory = new FactoryPage(driver);
        navigation = factory.getNavigationPage();
    }

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("@BeforeSuite: starting tests...");
    }

    @BeforeTest
    public void beforeTest() {
        LOG.info("@BeforeTest: before test...");

        if (driver == null) {
            fail("Driver cannot be null");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openUrl();
    }

    @BeforeClass
    public void beforeClass() {
        LOG.info("@BeforeClass: before class...");
    }

    @AfterClass
    public void afterClass() {
        LOG.info("@AfterClass: after class...");
    }

    @AfterTest
    public void afterTest() {
        LOG.info("@AfterTest: after test...");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("@AfterSuite: stopping tests...");
    }

    protected void openUrl() {
        String url = Property.INSTANCE.getPropertyValue("pageUrl");
        LOG.info("Opening page {}", url);
        driver.navigate().to(url);
    }

}

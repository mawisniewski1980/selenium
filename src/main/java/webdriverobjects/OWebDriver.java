package webdriverobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OWebDriver {

  private static final Logger LOG = LoggerFactory.getLogger(OWebDriver.class.getSimpleName());

  private static OWebDriver oWebDriverInstance = new OWebDriver();

  private OWebDriver() {
  }

  public static OWebDriver getOWebDriverInstance() {
    return oWebDriverInstance;
  }

  public WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/lib/chromedriver.exe");
    return new ChromeDriver();
  }

  public WebDriver initFireFoxBrowser() {
    LOG.info("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/lib/geckodriver.exe");
    return new FirefoxDriver();
  }

}

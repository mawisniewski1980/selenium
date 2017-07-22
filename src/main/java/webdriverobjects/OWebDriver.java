package webdriverobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import utilsobjects.OProperties;


public class OWebDriver {

  private static final Logger LOG = Logger.getLogger(OWebDriver.class);

  private static OWebDriver oWebDriverInstance = new OWebDriver();
  private OProperties properties = new OProperties();
  private String userPath = System.getProperty("user.dir");

  private OWebDriver() {
  }

  public static OWebDriver getOWebDriverInstance() {
    return oWebDriverInstance;
  }

  public WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, userPath + properties.getProperty("chromefilepath"));
    return new ChromeDriver();
  }

  public WebDriver initFireFoxBrowser() {
    LOG.info("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, userPath + properties.getProperty("firefoxfilepath"));
    return new FirefoxDriver();
  }

}

package webdriverobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import utilsobjects.OProperties;


public class OWebDriver {

  private static final Logger LOG = LogManager.getLogger("OWebDriver");

  private static OWebDriver oWebDriverInstance = new OWebDriver();

  private String userPath = System.getProperty("user.dir");
  private String chromeFilePath = userPath + OProperties.getProperty("chromefilepath");
  private String firefoxFilePath = userPath + OProperties.getProperty("firefoxfilepath");

  private OWebDriver() {
  }

  public static OWebDriver getOWebDriverInstance() {
    return oWebDriverInstance;
  }

  public WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeFilePath);
    return new ChromeDriver();
  }

  public WebDriver initFireFoxBrowser() {
    LOG.info("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, firefoxFilePath);
    return new FirefoxDriver();
  }

}

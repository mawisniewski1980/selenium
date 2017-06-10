package webdriverobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

public class OWebDriver {

  private static final Logger LOG = LoggerFactory.getLogger(OWebDriver.class.getSimpleName());

  private static WebDriverWait webDriverWait;
  private static WebDriver driver;

  public OWebDriver(BrowserName browser) {
    if (browser.equals(BrowserName.CHROME))
      driver = initChromeBrowser();

    if (browser.equals(BrowserName.FF))
      driver = initFireFoxBrowser();

    webDriverWait = new WebDriverWait(driver, 10);
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static WebDriverWait getWebDriverWait() {
    return webDriverWait;
  }

  private WebDriver initChromeBrowser() {
    System.out.println("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/lib/chromedriver.exe");
    driver = new ChromeDriver();
    return driver;
  }

  private WebDriver initFireFoxBrowser() {
    System.out.println("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/lib/geckodriver.exe");
    driver = new FirefoxDriver();
    return driver;

  }

}

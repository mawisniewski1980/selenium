package webdriverobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
  private Properties property = new Properties();
  private String userPath = System.getProperty("user.dir");

  private OWebDriver() {
  }

  public static OWebDriver getOWebDriverInstance() {
    return oWebDriverInstance;
  }

  public WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, userPath + getProperty("chromefilepath"));
    return new ChromeDriver();
  }

  public WebDriver initFireFoxBrowser() {
    LOG.info("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, userPath + getProperty("firefoxfilepath"));
    return new FirefoxDriver();
  }

  public String getProperty(String key) {

    try (BufferedReader buffer = new BufferedReader(new FileReader(new File(userPath + "/config.properties")))) {
      property.load(buffer);
      return property.getProperty(key);
    } catch (FileNotFoundException e) {
      LOG.info("No file 'config.properties'");
      e.printStackTrace();
    } catch (IOException e) {
      LOG.info("Connot read file 'config.properties'");
      e.printStackTrace();
    }
    return null;
  }
}

package webdriverobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import utilsobjects.Properties;


public class WebDriverObject {


  private static WebDriverObject webDriverObjectInstance = new WebDriverObject();

  private String userPath = System.getProperty("user.dir");
  private String chromeFilePath = userPath + Properties.getProperty("chromefilepath");
  private String firefoxFilePath = userPath + Properties.getProperty("firefoxfilepath");

  private WebDriverObject() {
  }

  public static WebDriverObject getOWebDriverInstance() {
    return webDriverObjectInstance;
  }

  public WebDriver initChromeBrowser() {
    //LOG.info("Driver Chrome Browser");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeFilePath);
    return new ChromeDriver();
  }

  public WebDriver initFireFoxBrowser() {
    //LOG.info("Driver FireFox Browser");
    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, firefoxFilePath);
    return new FirefoxDriver();
  }

}

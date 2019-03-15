package webdriverobjects;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.logging.Logger;


public final class WebDriverObject {

  private static final Logger LOG = Logger.getLogger(WebDriverObject.class.getName());

  private static WebDriverObject instance;
  private WebDriver driver;

  private WebDriverObject() {
  }

  public static WebDriverObject getInstance()
  {
    if (instance == null)
    {
      synchronized (WebDriverObject.class)
      {
        if(instance==null)
        {
          instance = new WebDriverObject();
        }
      }
    }
    return instance;
  }


  public synchronized WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    return new ChromeDriver(options);
  }

  public synchronized WebDriver initFireFoxBrowser() {
    LOG.info("Driver FireFox Browser");
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    return new FirefoxDriver(options);
  }

  public synchronized WebDriver initInternetExplorerBrowser() {
    LOG.info("Driver Internet Explorer Browser");
    WebDriverManager.iedriver().setup();
    InternetExplorerOptions options = new InternetExplorerOptions();
    return new InternetExplorerDriver(options);
  }


}

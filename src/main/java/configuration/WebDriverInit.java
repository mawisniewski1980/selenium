package configuration;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class WebDriverInit {

  private static final Logger LOG = LoggerFactory.getLogger(WebDriverInit.class);

  private static WebDriverInit instance;

  private WebDriverInit() {
  }

  public static WebDriverInit getInstance()
  {
    if (instance == null)
    {
      synchronized (WebDriverInit.class)
      {
        if(instance==null)
        {
          instance = new WebDriverInit();
        }
      }
    }
    return instance;
  }


  public synchronized WebDriver initChromeBrowser() {
    LOG.info("Driver Chrome Browser");
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito", "--start-maximized");
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

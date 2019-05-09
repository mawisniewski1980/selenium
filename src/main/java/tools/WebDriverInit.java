package tools;


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

    public WebDriverInit() {
    }

    public ChromeDriver initChromeBrowser() {
        LOG.info("Driver Chrome Browser");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");
        return new ChromeDriver(options);
    }

    public FirefoxDriver initFireFoxBrowser() {
        LOG.info("Driver FireFox Browser");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    public InternetExplorerDriver initInternetExplorerBrowser() {
        LOG.info("Driver Internet Explorer Browser");
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        return new InternetExplorerDriver(options);
    }


}

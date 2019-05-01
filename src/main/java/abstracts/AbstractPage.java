package abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

public abstract class AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

  protected WebDriver driver;
  protected Utils utils;

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
    this.utils = new Utils(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
  }

  public String getTitle() {
    LOG.info("Title of page: {}", driver.getTitle());
    return driver.getTitle();
  }
}

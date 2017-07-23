package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilsobjects.OUtils;

public abstract class OPage {

  private static final Logger LOG = LogManager.getLogger("OPage");

  protected WebDriver driver;
  protected OUtils utils;

  public OPage(WebDriver driver) {
    this.driver = driver;
    this.utils = new OUtils(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
  }

}

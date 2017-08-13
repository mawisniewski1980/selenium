package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilsobjects.Utils;

public abstract class PageObject {

  protected WebDriver driver;
  protected Utils utils;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    this.utils = new Utils(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
  }

  public String getTitle() {
    //LOG.info("Title of page: " + driver.getTitle());
    return driver.getTitle();
  }
}

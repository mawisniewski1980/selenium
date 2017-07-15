package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilsobjects.OUtils;

public abstract class OPage {

  protected WebDriver driver;
  protected OUtils utils;

  protected OPage(WebDriver driver) {
    this.driver = driver;
    this.utils = new OUtils(driver);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
  }

}

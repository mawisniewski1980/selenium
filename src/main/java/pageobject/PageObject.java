package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilsobjects.OUtils;

public class PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(PageObject.class.getName());

  protected WebDriver driver;
  protected OUtils utils;

  protected PageObject(WebDriver driver) {
    this.driver = driver;
    this.utils = new OUtils();
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
  }

}

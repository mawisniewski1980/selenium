package demoqa;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaServices extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaServices.class.getName());

  public DemoqaServices(WebDriver driver) {
    super(driver);
  }

}

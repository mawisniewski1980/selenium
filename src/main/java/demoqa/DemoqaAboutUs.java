package demoqa;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaAboutUs extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaAboutUs.class.getName());

  public DemoqaAboutUs(WebDriver driver) {
    super(driver);
  }

}

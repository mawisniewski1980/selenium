package phptravelsuserpage;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class PhpTravelsUserPage extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(PhpTravelsUserPage.class.getName());

  public PhpTravelsUserPage(WebDriver driver) {
    super(driver);
  }

}

package phptravelsuserpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobject.OPage;




public class PhpTravelsUserOPage extends OPage {

  private static final Logger LOG = Logger.getLogger(PhpTravelsUserOPage.class.getName());

  public PhpTravelsUserOPage(WebDriver driver) {
    super(driver);
  }

}

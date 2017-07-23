package phptravelsuserpage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobject.OPage;




public class PhpTravelsUserOPage extends OPage {

  private static final Logger LOG = LogManager.getLogger("PhpTravelsUserOPage");

  public PhpTravelsUserOPage(WebDriver driver) {
    super(driver);
  }

}

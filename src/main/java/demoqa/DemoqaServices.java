package demoqa;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;




public class DemoqaServices extends OPage {

  private static final Logger LOG = Logger.getLogger(DemoqaServices.class.getName());

  public DemoqaServices(WebDriver driver) {
    super(driver);
  }

  private final String demoqaServicesTextXpath = ".//article//div[@class='entry-content']/p";
  @FindBy(xpath = demoqaServicesTextXpath)
  private WebElement demoqaServicesText;

  public String getDemoqaServicesText(){
    LOG.info("Get text from Demoqa Services page");
    return utils.getText(demoqaServicesText);
  }
}

package demoqa;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.PageObject;

public class DemoqaServices extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaServices.class.getName());

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

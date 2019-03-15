package demoqa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;




public class DemoqaServices extends PageObject {



  public DemoqaServices(WebDriver driver) {
    super(driver);
  }

  private final String demoqaServicesTextXpath = ".//article//div[@class='entry-content']/p";
  @FindBy(xpath = demoqaServicesTextXpath)
  private WebElement demoqaServicesText;

  public String getDemoqaServicesText(){
    logger.info("Get text from Demoqa Services page");
    return utils.getText(demoqaServicesText);
  }
}

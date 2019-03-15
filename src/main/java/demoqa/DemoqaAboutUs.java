package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;


public class DemoqaAboutUs extends PageObject {


  public DemoqaAboutUs(WebDriver driver) {
    super(driver);
  }

  private final String aboutUsTextCss = "article .entry-content p";
  @FindBy(css = aboutUsTextCss)
  private WebElement aboutUsText;

  public String getAboutUsText() {
  logger.info("Get text from article from About Us page.");
  return utils.getText(aboutUsText);
  }
}

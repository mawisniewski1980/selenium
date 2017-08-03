package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;


public class DemoqaAboutUs extends PageObject {


  public DemoqaAboutUs(WebDriver driver) {
    super(driver);
  }

  private final String aboutAssTextCss = "article .entry-content p";
  @FindBy(css = aboutAssTextCss)
  private WebElement aboutAssText;

  public String getAboutAssText() {
  //LOG.info("Get text from article from About Ass page.");
  return utils.getText(aboutAssText);
  }
}

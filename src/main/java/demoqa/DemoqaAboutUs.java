package demoqa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;


public class DemoqaAboutUs extends OPage {

  private static final Logger LOG = LogManager.getLogger("DemoqaAboutUs");

  public DemoqaAboutUs(WebDriver driver) {
    super(driver);
  }

  private final String aboutAssTextCss = "article .entry-content p";
  @FindBy(css = aboutAssTextCss)
  private WebElement aboutAssText;

  public String getAboutAssText() {
  LOG.info("Get text from article from About Ass page.");
  return utils.getText(aboutAssText);
  }
}

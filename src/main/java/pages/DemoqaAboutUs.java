package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstracts.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DemoqaAboutUs extends AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaAboutUs.class);

  public DemoqaAboutUs(WebDriver driver) {
    super(driver);
  }

  private final String aboutUsTextCss = "article .entry-content p";
  @FindBy(css = aboutUsTextCss)
  private WebElement aboutUsText;

  public String getAboutUsText() {
    LOG.info("Get text from article from About Us page.");
  return utils.getText(aboutUsText);
  }
}

package pages;


import abstracts.AbstractPage;
import factories.FactoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static selectors.Selectors.HOME_LOGO;


public class HomePage extends AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);


  public HomePage(FactoryPage factory) {
    super(factory);
  }

  @FindBy(css = HOME_LOGO)
  private WebElement imgLogo;


  public HomePage imgLogoClick() {
    utils.linkClick(imgLogo);
    return this;
  }


}

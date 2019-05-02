package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstracts.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class HomePage extends AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);


  public HomePage(WebDriver driver) {
    super(driver);
  }

  private final String imgLogoCss = "#site_navigation a.site-anchor";
  @FindBy(css = imgLogoCss)
  private WebElement imgLogo;

  private final String tabsCss = "#tabs222";
  @FindBy(css = tabsCss)
  private WebElement tabs;

  private final String tabsLinksCss = "#tabs222 ul[role='tablist'] li";
  @FindBy(css = tabsLinksCss)
  private List<WebElement> tabsLinks;

  private final String tabsContentCss = "#tabs222 div[role='tabpanel']";
  @FindBy(css = tabsContentCss)
  private List<WebElement> tabsContent;

  private final String facebookIconCss = "li.facebook";
  @FindBy(css = facebookIconCss)
  private WebElement facebookIcon;

  private final String twiterIconCss = "li.twitter";
  @FindBy(css = twiterIconCss)
  private WebElement twiterIcon;

  private final String gplusIconCss = "li.gplus";
  @FindBy(css = gplusIconCss)
  private WebElement gplusIcon;

  public void tabsLinkClick(String title) {
    utils.linkClick(tabsLinks, title);
  }

  public String getTabsContentTitle(String title) {
    LOG.info("Get title from content");
    return tabsContent.get(utils.getId(tabsLinks, title)).getText();
  }

  public void clickOnFacebookIcon() {
    utils.linkClick(facebookIcon);
  }

}

package demoqa;

import demoqablog.DemoqaBlog;
import demoqacontact.DemoqaContact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.PageObject;

import java.util.List;

public class DemoqaNavbar extends PageObject {

  public static final Logger LOG = LoggerFactory.getLogger(DemoqaNavbar.class);

  public DemoqaNavbar(WebDriver driver) {
    super(driver);
  }

  private final String homeLinkCss = "#menu-item-38";
  @FindBy(css = homeLinkCss)
  private WebElement homeLink;

  private final String aboutUsLinkCss = "#menu-item-158";
  @FindBy(css = aboutUsLinkCss)
  private WebElement aboutUsLink;

  private final String servicesLinkCss = "#menu-item-155";
  @FindBy(css = servicesLinkCss)
  private WebElement servicesLink;

  private final String demoLinkCss = "#menu-item-66";
  @FindBy(css = demoLinkCss)
  private WebElement demoLink;

  private final String demoLinksListCss = ".dropdown-menu li";
  @FindBy(css = demoLinksListCss)
  private List<WebElement> demoLinksList;

  private final String draggableLinkCss = "#menu-item-73";
  @FindBy(css = draggableLinkCss)
  private WebElement draggableLink;

  private final String tabsLinkCss = "#menu-item-153";
  @FindBy(css = tabsLinkCss)
  private WebElement tabsLink;

  private final String blogLinkCss = "#menu-item-65";
  @FindBy(css = blogLinkCss)
  private WebElement blogLink;

  private final String contactLinkCss = "#menu-item-64";
  @FindBy(css = contactLinkCss)
  private WebElement contactLink;

  public DemoqaHome homeLinkClick() {
    utils.linkClick(homeLink);
    return new DemoqaHome(driver);
  }

  public DemoqaAboutUs aboutUsLinkClick() {
    utils.linkClick(aboutUsLink);
    return new DemoqaAboutUs(driver);
  }

  public DemoqaServices servicesLinkClick() {
    utils.linkClick(servicesLink);
    return new DemoqaServices(driver);
  }

  private void demoLinkClick() {
    utils.linkClick(demoLink);
    utils.waits.waitForVisibilityOfElements(demoLinksList);
  }

  public DemoqaDraggable draggableLinkClick() {
    demoLinkClick();
    utils.linkClick(draggableLink);
    return new DemoqaDraggable(driver);
  }

  public DemoqaTabs tabsLinkClick() {
    demoLinkClick();
    utils.linkClick(tabsLink);
    return new DemoqaTabs(driver);
  }

  public DemoqaBlog blogLinkClick() {
    utils.linkClick(blogLink);
    return new DemoqaBlog(driver);
  }

  public DemoqaContact contactLinkClick() {
    utils.linkClick(contactLink);
    return new DemoqaContact(driver);
  }
}

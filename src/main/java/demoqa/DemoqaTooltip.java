package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;
import utilsobjects.ODraggable;

import java.util.List;

public class DemoqaTooltip extends PageObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaTooltip.class.getName());

  public DemoqaTooltip(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityLinksCss = "#tabs-1 a";
  @FindBy(css = defaultFunctionalityLinksCss)
  private List<WebElement> defaultFunctionalityLinks;

  private final String defaultFunctionalityInputCss = "#tabs-1 #age";
  @FindBy(css = defaultFunctionalityInputCss)
  private WebElement defaultFunctionalityInput;

  private final String customAnimationDemoLinksCss = "#tabs-2 a";
  @FindBy(css = customAnimationDemoLinksCss)
  private List<WebElement> customAnimationDemoLinks;

  public String getDefaultFunctionalityLinksTextTooltip(String linkText) {
    utils.actions.moveTo(defaultFunctionalityLinks.get(utils.getId(defaultFunctionalityLinks, linkText))).waitTime(1);
    return driver.findElement(By.cssSelector(".ui-tooltip-content")).getText();
  }

  public String getDefaultFunctionalityInputTextTooltip() {
    utils.actions.moveTo(defaultFunctionalityInput).waitTime(1);
    return driver.findElement(By.cssSelector(".ui-tooltip-content")).getText();
  }

  public String getCustomeAnimationsLinksTextTooltip(String linkText) {
    utils.actions.moveTo(customAnimationDemoLinks.get(utils.getId(customAnimationDemoLinks, linkText))).waitTime(1);
    return driver.findElement(By.cssSelector(".ui-tooltip-content")).getText();
  }
}

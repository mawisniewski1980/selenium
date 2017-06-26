package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaTooltip extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaTooltip.class.getName());

  public DemoqaTooltip(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityParagraphCss = "p";
  private final String defaultFunctionalityLinkCss = "a";

  private final String defaultFunctionalityInputCss = "#age";
  @FindBy(css = defaultFunctionalityInputCss)
  private WebElement defaultFunctionalityInput;

  private final String customAnimationDemoShowOptionLinkCss = "#show-option";
  @FindBy(css = customAnimationDemoShowOptionLinkCss)
  private WebElement customAnimationDemoShowOptionLink;

  private final String customAnimationDemoHideOptionLinkCss = "#hide-option";
  @FindBy(css = customAnimationDemoHideOptionLinkCss)
  private WebElement customAnimationDemoHideOptionLink;

  private final String customAnimationDemoOpenEventLinkCss = "#open-event";
  @FindBy(css = customAnimationDemoOpenEventLinkCss)
  private WebElement customAnimationDemoOpenEventLink;

}

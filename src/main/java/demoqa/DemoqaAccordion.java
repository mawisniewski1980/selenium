package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaAccordion extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaAccordion.class.getName());

  public DemoqaAccordion(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityItemsCss = "#accordion h3";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String customizeIconsItemsCss = "#accordion_icons h3";
  @FindBy(css = customizeIconsItemsCss)
  private List<WebElement> customizeIconsItems;

  private final String customizeIconsOnItemsCss = "span";
  @FindBy(css = customizeIconsOnItemsCss)
  private List<WebElement> customizeIconsOnItems;

  private final String customizeIconsButtonCss = "button#toggle";
  @FindBy(css = customizeIconsButtonCss)
  private WebElement customizeIconsButton;

  private final String fillSpaceContainerCss = "#accordion-resizer #accordion_fill";
  @FindBy(css = fillSpaceContainerCss)
  private WebElement fillSpaceContainer;

  private final String fillSpaceItemsCss = "#accordion-resizer #accordion_fill h3";
  @FindBy(css = fillSpaceItemsCss)
  private List<WebElement> fillSpaceItems;

}

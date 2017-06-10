package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaSelectable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaSelectable.class.getName());

  public DemoqaSelectable(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityItemsCss = "#selectable li";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String displayAsGridItemsCss = "#selectable_grid li";
  @FindBy(css = displayAsGridItemsCss)
  private List<WebElement> displayAsGridItems;

  private final String serializeFeedbackCss = "#feedback #select-result";
  @FindBy(css = serializeFeedbackCss)
  private WebElement serializeFeedback;

  private final String serializeFeedbackItemsCss = "#selectable-serialize li";
  @FindBy(css = serializeFeedbackItemsCss)
  private List<WebElement> serializeFeedbackItems;

}

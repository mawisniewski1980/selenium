package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobject.PageObject;

public class DemoqaSlider extends PageObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaSlider.class.getName());

  public DemoqaSlider(WebDriver driver) {
    super(driver);
  }

  private final String rangeSliderAmountCss = "#amount1";
  @FindBy(css = rangeSliderAmountCss)
  private WebElement rangeSliderAmount;

  private final String rangeSliderRangeCss = ".ui-slider-range";
  @FindBy(css = rangeSliderRangeCss)
  private WebElement rangeSliderRange;

  private final String rangeSliderHandleCss = ".ui-slider-handle";
  @FindBy(css = rangeSliderHandleCss)
  private WebElement rangeSliderHandle;

}

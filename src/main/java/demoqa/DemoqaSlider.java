package demoqa;

import enums.DemoqaEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;
import utilsobjects.ODraggable;

public class DemoqaSlider extends OPage {

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

  public int getRangeAmount(){
    return Integer.parseInt(rangeSliderAmount.getAttribute("value"));
  }

  public DemoqaSlider setSliderHandle(DemoqaEnums.DemoqaSliderValue val) {
    int rangeInInput = getRangeAmount();
    int value = val.getValue();
    int jump = 100;

       if (value < rangeInInput) {
         while (rangeInInput != value) {
           utils.actions.moveByX(new ODraggable(rangeSliderHandle), -jump);
           rangeInInput = getRangeAmount();
         }
       } else {
         while (rangeInInput != value) {
           utils.actions.moveByX(new ODraggable(rangeSliderHandle), jump);
           rangeInInput = getRangeAmount();
         }
       }
    return this;
  }
}

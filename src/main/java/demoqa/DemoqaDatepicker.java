package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;

public class DemoqaDatepicker extends OPage {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaDatepicker.class.getName());

  public DemoqaDatepicker(WebDriver driver) {
    super(driver);
  }

  private final String defaultFuncionalityInputCss = "#datepicker1";
  @FindBy(css = defaultFuncionalityInputCss)
  private WebElement defaultFuncionalityInput;

  private final String animationsInputCss = "#datepicker2";
  @FindBy(css = animationsInputCss)
  private WebElement animationsInput;

  private final String animationsSelectCss = "#anim";
  @FindBy(css = animationsSelectCss)
  private WebElement animationsSelect;

  private final String displayMonthYearInputCss = "#datepicker3";
  @FindBy(css = displayMonthYearInputCss)
  private WebElement displayMonthYearInput;

  private final String formatDateInputCss = "#datepicker4";
  @FindBy(css = formatDateInputCss)
  private WebElement formatDateInput;

  private final String formatDateSelectCss = "#format";
  @FindBy(css = formatDateSelectCss)
  private WebElement formatDateSelect;

}

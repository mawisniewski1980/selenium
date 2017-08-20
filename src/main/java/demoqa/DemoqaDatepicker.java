package demoqa;

import date.DateUtils;
import enums.DemoqaEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobject.PageObject;

import java.time.LocalDate;
import java.util.Set;


public class DemoqaDatepicker extends PageObject {

  public DateUtils dateUtils;

  public DemoqaDatepicker(WebDriver driver) {
    super(driver);
    dateUtils = new DateUtils(driver);
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

  public DemoqaDatepicker defaultFuncionalityInputClick() {
    defaultFuncionalityInput.click();
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return this;
  }

  public Set<LocalDate> getDates() {
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return dateUtils.getDates();
  }

  public String getDateFromDefaultFunctionalityInput() {
    return defaultFuncionalityInput.getAttribute("value");
  }

  public String getDateFromAnimationsInput() {
    return animationsInput.getAttribute("value");
  }

  public String getDefaultTextFromAnimationsInput() {
    return animationsInput.getAttribute("placeholder");
  }

  public void selectAnimations(DemoqaEnums.DemoqaAnimationsList dEnums) {
    Select anim = new Select(animationsSelect);
    anim.selectByValue(dEnums.getValue());
  }

  public DemoqaDatepicker animationsInputClick() {
    animationsInput.click();
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return this;
  }

  public String getDateFromDisplayMonthAndYearInput() {
    return displayMonthYearInput.getAttribute("value");
  }

  public String getDefaultTextFromDisplayMonthAndYearInput() {
    return displayMonthYearInput.getAttribute("placeholder");
  }

  public DemoqaDatepicker displayMonthAndYearInputClick() {
    displayMonthYearInput.click();
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return this;
  }

  public String getDateFromFormatDateInput() {
    return formatDateInput.getAttribute("value");
  }

  public String getDefaultTextFromFormatDateInput() {
    return formatDateInput.getAttribute("placeholder");
  }

  public void selectFormatDate(DemoqaEnums.DemoqaFormatDateList dEnums) {
    Select formatDate = new Select(formatDateSelect);
    formatDate.selectByValue(dEnums.getValue());
  }

  public DemoqaDatepicker formatDateInputClick() {
    formatDateInput.click();
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return this;
  }

}

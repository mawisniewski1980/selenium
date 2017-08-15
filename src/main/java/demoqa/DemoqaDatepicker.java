package demoqa;

import date.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

import java.time.LocalDate;
import java.util.List;


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

  public List<LocalDate> getDates() {
    utils.getWaits().waitForVisibilityOfElement(dateUtils.getContainer());
    return dateUtils.getDates();
  }

  public String getDateFromDefaultFunctionalityInput() {
    return defaultFuncionalityInput.getAttribute("value");
  }
}

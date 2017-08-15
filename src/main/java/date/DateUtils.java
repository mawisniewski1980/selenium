package date;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class DateUtils extends PageObject {


    public DateUtils(WebDriver driver) {
        super(driver);
    }

    private final String containerCss = ".ui-datepicker";
    @FindBy(css = containerCss)
    private WebElement container;

    private final String previousButtonCss = ".ui-icon-circle-triangle-w";
    @FindBy(css = previousButtonCss)
    private WebElement previousButton;

    private final String nextButtonCss = ".ui-icon-circle-triangle-e";
    @FindBy(css = nextButtonCss)
    private WebElement nextButton;

    private final String monthCss = ".ui-datepicker-month";
    @FindBy(css = monthCss)
    private WebElement month;

    private final String yearCss = ".ui-datepicker-year";
    @FindBy(css = yearCss)
    private WebElement year;

    private final String daysCss = containerCss + " td[data-handler='selectDay']";
    @FindBy(css = daysCss)
    private List<WebElement> days;

    private final String todayDateCss = containerCss + " .ui-datepicker-today";
    @FindBy(css = todayDateCss)
    private WebElement today;

    private final String currentDateCss = containerCss + " .ui-datepicker-current-day";
    @FindBy(css = currentDateCss)
    private WebElement currentDate;

    private final String activeDateCss = containerCss + " .ui-state-active";
    @FindBy(css = activeDateCss)
    private WebElement activeDate;

    public WebElement getContainer() {
        return container;
    }

    public DateUtils previousButtonClick() {
        utils.getWaits().waitForVisibilityOfElement(container);
        previousButton.click();
        return this;
    }

    public DateUtils nextButtonClick() {
        utils.getWaits().waitForVisibilityOfElement(container);
        nextButton.click();
        return this;
    }

    public String getMonthAsString() {
        utils.getWaits().waitForVisibilityOfElement(container);
        return utils.getText(month);
    }

    public int getMonthAsInt() {
        utils.getWaits().waitForVisibilityOfElement(container);
        int a = 0;
        for (Month val : Month.values()) {
            if (utils.getText(month).equalsIgnoreCase(val.getDisplayName(TextStyle.FULL, Locale.US))) {
                a = val.getValue();
                return a;
            }
        }
        return a;
    }

    public int getYearAsInt() {
        utils.getWaits().waitForVisibilityOfElement(container);
        return Integer.parseInt(utils.getText(year));
    }

    public boolean isDateTodayDisplay() {
        utils.getWaits().waitForVisibilityOfElement(container);
        return utils.isElementPresent(By.cssSelector(todayDateCss));
    }

    public LocalDate getDateToday() {
        utils.getWaits().waitForVisibilityOfElement(container);
        int month = Integer.parseInt(today.getAttribute("data-month"));
        int year = Integer.parseInt(today.getAttribute("data-year"));
        int day = Integer.parseInt(today.findElement(By.tagName("a")).getText());
        return LocalDate.of(year, month + 1, day);
    }

    public LocalDate getCurrentDate() {
        utils.getWaits().waitForVisibilityOfElement(container);
        int month = Integer.parseInt(currentDate.getAttribute("data-month"));
        int year = Integer.parseInt(currentDate.getAttribute("data-year"));
        int day = Integer.parseInt(currentDate.findElement(By.tagName("a")).getText());
        return LocalDate.of(year, month + 1, day);
    }

    public LocalDate getActiveDate() {
        utils.getWaits().waitForVisibilityOfElement(container);
        int month = Integer.parseInt(activeDate.getAttribute("data-month"));
        int year = Integer.parseInt(activeDate.getAttribute("data-year"));
        int day = Integer.parseInt(activeDate.findElement(By.tagName("a")).getText());
        return LocalDate.of(year, month + 1, day);
    }

    public void setMonthAndYear(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        setYear(date);
        setMonth(date);
    }

    public void setYear(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        int year = getYearAsInt();
        if(!checkIfDateIsOnDatePicker(date)) {

            if(date.getYear() < year) {
                while (!checkIfYearIsEqualToYearOnDatePicker(date)) {
                    if (checkIfYearIsEqualToYearOnDatePicker(date))
                        break;
                    previousButtonClick();
                }
            } else if (date.getYear() > year) {
                while (!checkIfYearIsEqualToYearOnDatePicker(date)) {
                    if (checkIfYearIsEqualToYearOnDatePicker(date))
                        break;
                    nextButtonClick();
                }
            }
        }
    }

    public void setMonth(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        int month = getMonthAsInt();
        if(!checkIfDateIsOnDatePicker(date)) {

            if(date.getMonthValue() < month) {
                while (!checkIfMonthIsEqualToMonthOnDatePicker(date)) {
                    if (checkIfMonthIsEqualToMonthOnDatePicker(date))
                        break;
                    previousButtonClick();
                }
            } else if (date.getMonthValue() > month) {
                while (!checkIfMonthIsEqualToMonthOnDatePicker(date)) {
                    if (checkIfMonthIsEqualToMonthOnDatePicker(date))
                        break;
                    nextButtonClick();
                }
            }
        }
    }

    public boolean checkIfYearIsEqualToYearOnDatePicker(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        if(date.getYear() == getYearAsInt())
            return true;
        return false;
    }

    public boolean checkIfMonthIsEqualToMonthOnDatePicker(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        if(date.getMonthValue() == getMonthAsInt())
            return true;
        return false;
    }

    public boolean checkIfDateIsOnDatePicker(LocalDate date) {
        utils.getWaits().waitForVisibilityOfElement(container);
        if(getDates().contains(date))
            return true;
        return false;
    }

    public List<LocalDate> getDates() {

        List<LocalDate> listWithDates = new LinkedList<>();
        utils.getWaits().waitForVisibilityOfElement(container);

        for (WebElement element : days) {
            int month = Integer.parseInt(element.getAttribute("data-month"));
            int year = Integer.parseInt(element.getAttribute("data-year"));
            int day = Integer.parseInt(element.findElement(By.tagName("a")).getText());
            listWithDates.add(LocalDate.of(year, month + 1, day));
        }
        return listWithDates;
    }


}

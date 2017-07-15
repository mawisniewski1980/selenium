package date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.plugin.com.Utils;

import java.time.LocalDate;

public class ODate {

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

    private final String todayDateCss = ".ui-datepicker-today";
    @FindBy(css = todayDateCss)
    private WebElement today;

    private final String currentDateCss = ".ui-datepicker-current-day";
    @FindBy(css = currentDateCss)
    private WebElement currentDate;

    private final String activeDateCss = ".ui-state-active";
    @FindBy(css = activeDateCss)
    private WebElement activeDate;

    //TODO
    public LocalDate getDateToday() {


        return null;
    }

}

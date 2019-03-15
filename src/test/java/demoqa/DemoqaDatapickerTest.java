package demoqa;

import date.DateFormatterUtils;
import enums.DemoqaEnums;
import enums.PageUrls;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.testng.Assert.assertEquals;


public class DemoqaDatapickerTest extends TestObject {


    private DemoqaDatepicker demoqaDatepicker;
    private DemoqaCommonElements commonElements;

    @BeforeTest
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        demoqaDatepicker = new DemoqaDatepicker(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.datapickerLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Datepicker page title:", "Datepicker | Demoqa", demoqaDatepicker.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Datepicker entry title:", "Datepicker", commonElements.getEntryTitle());
    }

    @Test
    public void checkIfDateTodayIsDisplayedOnDefaultFunctionalityDate() {
        commonElements.tabsLinkClick("Default functionality");
        demoqaDatepicker.defaultFuncionalityInputClick();
        //assertTrue("Check if date today is displayed on the data picker", demoqaDatepicker.dateUtils.isDateTodayDisplay());
    }

    @Test
    public void checkIfDateTodayIsEqualsDateOnDefaultFunctionalityDate() {

        commonElements.tabsLinkClick("Default functionality");
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        demoqaDatepicker.defaultFuncionalityInputClick();
        //assertEquals("Check if date today is equals date today on data picker", today, demoqaDatepicker.dateUtils.getDateToday());
    }

    @Test
    public void chooseDateAndCheckWithDateOnInputFieldOnDefaultFunctionality() {
        commonElements.tabsLinkClick("Default functionality");
        demoqaDatepicker.defaultFuncionalityInputClick();
        LocalDate dateTest = LocalDate.now().plusDays(1);
        String date = DateFormatterUtils.getFormattedDate_MMMMd_uuuu(dateTest);

        demoqaDatepicker.dateUtils.setDate(dateTest);
        assertEquals("Choose date and check with date on input field on Default Functionality.", date, demoqaDatepicker.getDateFromDefaultFunctionalityInput());
    }

    @Test
    public void checkDefaultTextOnAnimationsTabInInputField() {
        commonElements.tabsLinkClick("Animations");
        assertEquals("Check if default text on input field is visible ", "Pick Date", demoqaDatepicker.getDefaultTextFromAnimationsInput());
    }

    @Test
    public void selectAnimationsOnAnimationsTabInInputField() {
       commonElements.tabsLinkClick("Animations");
       demoqaDatepicker.selectAnimations(DemoqaEnums.DemoqaAnimationsList.FADEIN);
        LocalDate dateTest = LocalDate.now().plusDays(3);
        String date = DateFormatterUtils.getFormattedDate_MMMMd_uuuu(dateTest);

        demoqaDatepicker.animationsInputClick();
        demoqaDatepicker.dateUtils.setDate(dateTest);
        assertEquals("Check choosed date ", date, demoqaDatepicker.getDateFromAnimationsInput());
    }

    @Test
    public void checkDefaultTextOnDisplayMonthAndYearOption() {
        commonElements.tabsLinkClick("Display month & year");
        assertEquals("Check if default text on input field is visible ", "Pick Date", demoqaDatepicker.getDefaultTextFromDisplayMonthAndYearInput());
    }


    @Test
    public void checkIfDateTodayIsDisplayedOnDisplayMonthAndYearDate() {
        commonElements.tabsLinkClick("Display month & year");
        demoqaDatepicker.displayMonthAndYearInputClick();
        //assertTrue("Check if date today is displayed on the data picker", demoqaDatepicker.dateUtils.isDateTodayDisplay());
    }

    @Test
    public void checkIfDateTodayIsEqualsDateOnDisplayMonthAndYearDate() {
        commonElements.tabsLinkClick("Display month & year");
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        demoqaDatepicker.displayMonthAndYearInputClick();
        //assertEquals("Check if date today is equals date today on data picker", today, demoqaDatepicker.dateUtils.getDateToday());
    }

    @Test
    public void setDateOnDisplayMonthAndYearOption() {
        commonElements.tabsLinkClick("Display month & year");

        LocalDate dateTest = LocalDate.now().plusDays(25);
        String date = DateFormatterUtils.getFormattedDate_MMMMd_uuuu(dateTest);

        demoqaDatepicker.displayMonthAndYearInputClick();
        demoqaDatepicker.dateUtils.setDateMonthYearAsSelect(dateTest);
        assertEquals("Check choosed date ",  demoqaDatepicker.getDateFromDisplayMonthAndYearInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatDefault() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(1);
        String date = DateFormatterUtils.getFormattedDate_mm_dd_yy_dafault(dataTest);

        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.ISO);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.DEFAULT);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatIso() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(1);
        String date = DateFormatterUtils.getFormattedDate_yy_mm_dd_iso(dataTest);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.ISO);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatShort() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(1);
        String date = DateFormatterUtils.getFormattedDate_dM_y_short(dataTest);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.SHORT);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatMedium() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(2);
        String date = DateFormatterUtils.getFormattedDate_dMM_y_medium(dataTest);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.MEDIUM);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatFull() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(3);
        String date = DateFormatterUtils.getFormattedDate_DD_dMM_yy_full(dataTest);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.FULL);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

    @Test
    public void setDateOnFormatDateAndCheckFormatWithDay() {

        commonElements.tabsLinkClick("Format date");
        LocalDate dataTest = LocalDate.now().plusDays(5);
        String date = DateFormatterUtils.getFormattedDate_day_d_of_MM_inTheYear_yy_withDay(dataTest);

        demoqaDatepicker.formatDateInputClick();
        demoqaDatepicker.dateUtils.setDate(dataTest);
        demoqaDatepicker.selectFormatDate(DemoqaEnums.DemoqaFormatDateList.WITHDAY);
        assertEquals("Check choosed date", demoqaDatepicker.getDateFromFormatDateInput(), date);
    }

}

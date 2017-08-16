package demoqa;

import enums.PageUrls;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaDatapickerTest extends TestObject {


    private DemoqaDatepicker demoqaDatepicker;
    private DemoqaCommonElements commonElements;

    @Before
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
        assertTrue("Check if date today is displayed on the data picker", demoqaDatepicker.dateUtils.isDateTodayDisplay());
    }

    @Test
    public void checkIfDateTodayIsEqualsDateOnDefaultFunctionalityDate() {

        commonElements.tabsLinkClick("Default functionality");
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        demoqaDatepicker.defaultFuncionalityInputClick();
        assertEquals("Check if date today is equals date today on data picker", demoqaDatepicker.dateUtils.getDateToday(), today);
    }

    //TODO
    @Test
    public void chooseDateAndCheckWithDateOnInputFieldOnDefaultFunctionality() {
        commonElements.tabsLinkClick("Default functionality");
        demoqaDatepicker.defaultFuncionalityInputClick();
        demoqaDatepicker.dateUtils.setDate(LocalDate.of(2016,11,05));
        utils.getWaits().waitTime(6);
        System.out.println(demoqaDatepicker.getDateFromDefaultFunctionalityInput());
    }
}

package demoqa;

import enums.PageUrls;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;




import static org.junit.Assert.assertEquals;

public class DemoqaDatapickerTest extends OTest {

    private static final Logger LOG = Logger.getLogger(DemoqaDatapickerTest.class.getName());

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
        assertEquals("Check Datepicker page title:", "Datepicker | Demoqa", utils.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Datepicker entry title:", "Datepicker", commonElements.getEntryTitle());
    }

    @Test
    public void checkDefaultFunctionalityDate() {
        commonElements.tabsLinkClick("Default functionality");


    }
}

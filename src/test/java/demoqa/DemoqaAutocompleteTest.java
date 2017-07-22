package demoqa;

import enums.PageUrls;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;



import static com.google.common.collect.ImmutableList.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaAutocompleteTest extends OTest {

    private static final Logger LOG = Logger.getLogger(DemoqaAutocompleteTest.class.getName());

    private DemoqaAutocomplete dAuto;
    private DemoqaCommonElements commonElements;

    @Before
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        dAuto = new DemoqaAutocomplete(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.autocompleteLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Menu page title:", "Autocomplete | Demoqa", utils.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Menu entry title:", "Autocomplete", commonElements.getEntryTitle());
    }

    @Test
    public void defaultFunctionalityChooseValue() {
        commonElements.tabsLinkClick("Default functionality");
        dAuto.setInputAutocompleteDefaultFunctionality("ActionScript");
        assertEquals("", "ActionScript", dAuto.getInputAutocompleteDefaultFunctionalityText());
    }

    @Test
    public void multipleValues() {
        commonElements.tabsLinkClick("Multiple Values");
        dAuto.setInputAutocompleteMultipleValue(of("ActionScript", "AppleScript", "BASIC", "C"));
        assertTrue(of("ActionScript", "AppleScript", "BASIC", "C").containsAll(dAuto.getInputAutocompleteMultipleValueText()));
    }

    @Test
    public void categoriesChooseValue() {
        commonElements.tabsLinkClick("Categories");
        dAuto.setInputAutocompleteCategories("anders andersson");
        assertEquals("", "anders andersson", dAuto.getInputAutocompleteCategoriesText());
    }
}

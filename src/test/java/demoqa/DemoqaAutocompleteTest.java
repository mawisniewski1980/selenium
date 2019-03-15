package demoqa;

import enums.PageUrls;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static com.google.common.collect.ImmutableList.of;
import static org.testng.Assert.assertEquals;


public class DemoqaAutocompleteTest extends TestObject {


    private DemoqaAutocomplete dAuto;
    private DemoqaCommonElements commonElements;

    @BeforeTest
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        dAuto = new DemoqaAutocomplete(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.autocompleteLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Menu page title:", "Autocomplete | Demoqa", dAuto.getTitle());
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
        //assertTrue(of("ActionScript", "AppleScript", "BASIC", "C").containsAll(dAuto.getInputAutocompleteMultipleValueText()));
    }

    @Test
    public void categoriesChooseValue() {
        commonElements.tabsLinkClick("Categories");
        dAuto.setInputAutocompleteCategories("anders andersson");
        assertEquals("", "anders andersson", dAuto.getInputAutocompleteCategoriesText());
    }
}

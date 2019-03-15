package demoqa;


import enums.PageUrls;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertEquals;


public class DemoqaTooltipTest extends TestObject {



    private DemoqaTooltip tooltip;
    private DemoqaCommonElements commonElements;

    @BeforeTest
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        tooltip = new DemoqaTooltip(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.tooltipLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check page title", "Tooltip | Demoqa", tooltip.getTitle() );
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check entry title", "Tooltip", commonElements.getEntryTitle() );
    }

    @Test
    public void checkDefaultFunctionalityTooltipUnderTooltipLink() {
        commonElements.tabsLinkClick("Default functionality");
        assertEquals("Check tooltip under Tooltip link", "That's what this widget is", tooltip.getDefaultFunctionalityLinksTextTooltip("Tooltips"));
    }

    @Test
    public void checkDefaultFunctionalityTooltipUnderThemeRollerLink() {
        commonElements.tabsLinkClick("Default functionality");
        assertEquals("Check tooltip under ThemeRoller link", "ThemeRoller: jQuery UI's theme builder application", tooltip.getDefaultFunctionalityLinksTextTooltip("ThemeRoller"));
    }

    @Test
    public void checkDefaultFunctionalityTooltipUnderInput() {
        commonElements.tabsLinkClick("Default functionality");
        assertEquals("Check tooltip under input field", "We ask for your age only for statistical purposes.", tooltip.getDefaultFunctionalityInputTextTooltip());
    }

    @Test
    public void checkCustomAnimationDemoTooltipUnderShowLink() {
        commonElements.tabsLinkClick("custom animation demo");
        assertEquals("Check tooltip under Show link", "slide down on show", tooltip.getCustomeAnimationsLinksTextTooltip("show"));
    }

    @Test
    public void checkCustomAnimationDemoTooltipUnderHideLink() {
        commonElements.tabsLinkClick("custom animation demo");
        assertEquals("Check tooltip under Hide link", "explode on hide", tooltip.getCustomeAnimationsLinksTextTooltip("hide"));
    }

    @Test
    public void checkCustomAnimationDemoTooltipUnderOpenEventLink() {
        commonElements.tabsLinkClick("custom animation demo");
        assertEquals("Check tooltip under Open event link", "move down on show2", tooltip.getCustomeAnimationsLinksTextTooltip("open event"));
    }

}

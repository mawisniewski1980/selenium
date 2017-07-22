package demoqa;

import enums.PageUrls;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;




import static org.junit.Assert.assertEquals;

public class DemoqaMenuTest extends OTest {


    private static final Logger LOG = Logger.getLogger(DemoqaMenuTest.class.getName());

    private DemoqaMenu dMenu;
    private DemoqaCommonElements commonElements;

    @Before
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        dMenu = new DemoqaMenu(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.menuLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Menu page title:", "Menu | Demoqa", utils.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Menu entry title:", "Menu", commonElements.getEntryTitle());
    }

    @Test
    public void moveToLinkOnSimpleMenuTab() {
        commonElements.tabsLinkClick("Simple Menu");
        dMenu.hoverLinkSimpleMenuItem("Contact");
        utils.waits.waitTime(1);
    }

    @Test
    public void moveToLinkOnMenuWIthSubMenuTab() {
        commonElements.tabsLinkClick("Menu With Sub Menu");
        dMenu.hoverMenuWithSubmenuListSubLevel("News", "Sub Menu Item 1");
        utils.waits.waitTime(1);
    }
}

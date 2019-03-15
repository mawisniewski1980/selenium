package demoqa;

import enums.PageUrls;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertEquals;


public class DemoqaMenuTest extends TestObject {


    private DemoqaMenu dMenu;
    private DemoqaCommonElements commonElements;

    @BeforeTest
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        dMenu = new DemoqaMenu(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.menuLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Menu page title:", "Menu | Demoqa", dMenu.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Menu entry title:", "Menu", commonElements.getEntryTitle());
    }

    @Test
    public void moveToLinkOnSimpleMenuTab() {
        commonElements.tabsLinkClick("Simple Menu");
        dMenu.hoverLinkSimpleMenuItem("Contact");
        utils.getWaits().waitTime(1);
    }

    @Test
    public void moveToLinkOnMenuWIthSubMenuTab() {
        commonElements.tabsLinkClick("Menu With Sub Menu");
        dMenu.hoverMenuWithSubmenuListSubLevel("News", "Sub Menu Item 1");
        utils.getWaits().waitTime(1);
    }
}

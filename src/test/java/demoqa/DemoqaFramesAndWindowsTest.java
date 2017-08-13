package demoqa;

import enums.PageUrls;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;

public class DemoqaFramesAndWindowsTest extends TestObject {


    private DemoqaFramesAndWindows demoqaFrames;
    private DemoqaCommonElements commonElements;

    @Before
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        demoqaFrames = new DemoqaFramesAndWindows(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.framesAndWindowsLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Frames and windows page title:", "Frames and windows | Demoqa", demoqaFrames.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Frames and windows entry title:", "Frames and windows", commonElements.getEntryTitle());
    }

    @Test
    public void newBrowserTabLinkClick() {

        commonElements.tabsLinkClick("Open New Window");
        demoqaFrames.newBrowserTabLinkClick();
        assertEquals("Check Frames and windows page title:", "Frames and windows | Demoqa", demoqaFrames.getTitle());
        utils.getActions().switchToDefaultWindow();
        assertEquals("Check Frames and windows entry title:", "Frames and windows", commonElements.getEntryTitle());
    }

    @Test
    public void openSeparateWindowLink() {

        commonElements.tabsLinkClick("Open Seprate New Window");
        demoqaFrames.openSeparateWindowLinkClick();
        utils.getActions().switchToNextWindow();

        assertEquals("Check Frames and windows page title:", "Page Not Found | TOOLSQA", demoqaFrames.getTitle());
    }

    @Test
    public void openFramesAndWindows() {

        commonElements.tabsLinkClick("Frameset");
        demoqaFrames.framsetWindowLinkClick();
        utils.getActions().switchToNextWindow();

        assertEquals("Check Frames and windows page title:", "HTML Frames - Example 1", demoqaFrames.getTitle());
    }
}

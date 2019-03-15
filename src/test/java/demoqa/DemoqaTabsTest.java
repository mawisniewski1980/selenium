package demoqa;

import enums.PageUrls.PageUrl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertEquals;


public class DemoqaTabsTest extends TestObject {



  private DemoqaTabs tabs;
  private DemoqaCommonElements commonElements;

  @BeforeTest
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    tabs = new DemoqaTabs(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.tabsLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check page title", "Tabs | Demoqa", tabs.getTitle() );
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check page title", "Tabs", commonElements.getEntryTitle() );
  }

  @Test
  public void checkTab3ContentTextContains() {
    tabs.tabsLinkClick("Tab 3");
   // assertTrue("Check if text on Tab3 contians \"Mauris eleifend est et turpis.\" ", tabs.getTabsContent3().contains("Mauris eleifend est et turpis. ") );
  }

  @Test
  public void checkTab2ContentTextStartsWith() {
    tabs.tabsLinkClick("Tab 2");
    //assertTrue("Check if text on Tab2 start with \"Morbi tincidunt, d\" ", tabs.getTabsContent2().startsWith("Morbi tincidunt, d" ) );
  }

  @Test
  public void checkTab1ContentText() {
    tabs.tabsLinkClick("Tab 1");
    //assertTrue("Check if text on Tab2 start with \"Morbi tincidunt, d\" ", tabs.getTabsContent1().contains("Proin elit arcu, rutrum commodo") );
  }

}

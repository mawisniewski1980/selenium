package demoqa;

import enums.PageUrls.PageUrl;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaTabsTest extends OTest {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaTabsTest.class);

  private DemoqaTabs tabs;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    tabs = new DemoqaTabs(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.tabsLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check page title", "Tabs | Demoqa", utils.getTitle() );
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check page title", "Tabs", commonElements.getEntryTitle() );
  }

  @Test
  public void checkTab3ContentTextContains() {
    tabs.tabsLinkClick("Tab 3");
    assertTrue("Check if text on Tab3 contians \"Mauris eleifend est et turpis.\" ", tabs.getTabsContent3().contains("Mauris eleifend est et turpis. ") );
  }

  @Test
  public void checkTab2ContentTextStartsWith() {
    tabs.tabsLinkClick("Tab 2");
    assertTrue("Check if text on Tab2 start with \"Morbi tincidunt, d\" ", tabs.getTabsContent2().startsWith("Morbi tincidunt, d" ) );
  }

  @Test
  public void checkTab1ContentText() {
    tabs.tabsLinkClick("Tab 1");
    assertTrue("Check if text on Tab2 start with \"Morbi tincidunt, d\" ", tabs.getTabsContent1().contains("Proin elit arcu, rutrum commodo") );
  }

}

package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaTabsTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaTabsTest.class);

  private DemoqaTabs tabs;
  private DemoqaNavbar navbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    navbar = new DemoqaNavbar(driver);
    tabs = new DemoqaTabs(driver);
    commonElements = new DemoqaCommonElements(driver);
    navbar.tabsLinkClick();
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

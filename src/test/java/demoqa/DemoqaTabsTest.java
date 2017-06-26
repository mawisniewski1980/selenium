package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

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
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Tabs | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Tabs");
  }

  @Test
  public void getTabsContent() {

    tabs.tabsLinkClick("Tab 2");
    assertThat(tabs.getTabsContent2()).startsWith("Morbi tincidunt, d");

    tabs.tabsLinkClick("Tab 3");
    assertThat(tabs.getTabsContent3()).contains("Mauris eleifend est et turpis. ");

    tabs.tabsLinkClick("Tab 1");
    assertThat(tabs.getTabsContent1()).contains("Proin elit arcu, rutrum commodo");
  }

}

package demoqa;

import com.google.common.collect.ImmutableList;
import demoqablog.DemoqaBlog;
import enums.PageUrls.PageUrl;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaHomeTest extends TestObject {


  private DemoqaHome demoqaHome;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaHome = new DemoqaHome(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.homeLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Home page title:", "Demoqa | Just another WordPress site", utils.getTitle());
  }

  @Test
  public void clickHomeLink() {
    commonElements.demoqaNavbar.aboutUsLinkClick();
    assertEquals("About us", commonElements.getEntryTitle());
    assertEquals("About us | Demoqa", utils.getTitle());

    commonElements.demoqaNavbar.servicesLinkClick();
    assertEquals("Services", commonElements.getEntryTitle());
    assertEquals("Services | Demoqa", utils.getTitle());

    commonElements.demoqaNavbar.draggableLinkClick();
    assertEquals("Draggable", commonElements.getEntryTitle());
    assertEquals("Draggable | Demoqa", utils.getTitle());

    commonElements.demoqaNavbar.tabsLinkClick();
    assertEquals("Tabs", commonElements.getEntryTitle());
    assertEquals("Tabs | Demoqa", utils.getTitle());

    commonElements.demoqaNavbar.blogLinkClick();
    assertTrue(new DemoqaBlog(driver).getEntryTitle().containsAll(ImmutableList.of("Sample Post", "Sample Post2")));
    assertEquals("Blog | Demoqa | Just another WordPress site", utils.getTitle());

    commonElements.demoqaNavbar.contactLinkClick();
    assertEquals("Contact", commonElements.getEntryTitle());
    assertEquals("Contact | Demoqa", utils.getTitle());

    commonElements.demoqaNavbar.homeLinkClick();
    assertEquals("Home", commonElements.getEntryTitle());
    assertEquals("Demoqa | Just another WordPress site", utils.getTitle());
  }

  @Test
  public void contentTabsTitleHome() {

    commonElements.demoqaNavbar.homeLinkClick();

    demoqaHome.tabsLinkClick("Tab 4");
    assertTrue(demoqaHome.getTabsContentTitle("Tab 4").contains("Content 4 Title"));

    demoqaHome.tabsLinkClick("Tab 1");
    assertTrue(demoqaHome.getTabsContentTitle("Tab 1").contains("Content 1 Title"));

    demoqaHome.tabsLinkClick("Tab 2");
    assertTrue(demoqaHome.getTabsContentTitle("Tab 2").contains("Content 2 Title"));

    demoqaHome.tabsLinkClick("Tab 5");
    assertTrue(demoqaHome.getTabsContentTitle("Tab 5").contains("Content 5 Title"));

    demoqaHome.tabsLinkClick("Tab 3");
    assertTrue(demoqaHome.getTabsContentTitle("Tab 3").contains("Content 3 Title"));
  }

  @Test
  public void clickOnIconsInFooter() {
    demoqaHome.clickOnFacebookIcon();
  }
}

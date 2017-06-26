package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import demoqablog.DemoqaBlog;
import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaHomeTest extends TestObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaHomeTest.class.getName());

  private DemoqaHome demoqaHome;
  private DemoqaNavbar demoqaNavbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaHome = new DemoqaHome(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaNavbar = new DemoqaNavbar(driver);
    demoqaNavbar.homeLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Demoqa | Just another WordPress site");
  }

  @Test
  public void clickHomeLink() {
    demoqaNavbar.aboutUsLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("About us");
    assertThat(utils.getTitle()).isEqualTo("About us | Demoqa");

    demoqaNavbar.servicesLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("Services");
    assertThat(utils.getTitle()).isEqualTo("Services | Demoqa");

    demoqaNavbar.draggableLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("Draggable");
    assertThat(utils.getTitle()).isEqualTo("Draggable | Demoqa");

    demoqaNavbar.tabsLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("Tabs");
    assertThat(utils.getTitle()).isEqualTo("Tabs | Demoqa");

    demoqaNavbar.blogLinkClick();
    assertThat(new DemoqaBlog(driver).getEntryTitle()).containsAll(ImmutableList.of("Sample Post", "Sample Post2"));
    assertThat(utils.getTitle()).isEqualTo("Blog | Demoqa | Just another WordPress site");

    demoqaNavbar.contactLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("Contact");
    assertThat(utils.getTitle()).isEqualTo("Contact | Demoqa");

    demoqaNavbar.homeLinkClick();
    assertThat(commonElements.getEntryTitle()).isEqualTo("Home");
    assertThat(utils.getTitle()).isEqualTo("Demoqa | Just another WordPress site");
  }

  @Test
  public void contentTabsTitleHome() {

    demoqaNavbar.homeLinkClick();

    demoqaHome.tabsLinkClick("Tab 4");
    assertThat(demoqaHome.getTabsContentTitle("Tab 4")).contains("Content 4 Title");

    demoqaHome.tabsLinkClick("Tab 1");
    assertThat(demoqaHome.getTabsContentTitle("Tab 1")).contains("Content 1 Title");

    demoqaHome.tabsLinkClick("Tab 2");
    assertThat(demoqaHome.getTabsContentTitle("Tab 2")).contains("Content 2 Title");

    demoqaHome.tabsLinkClick("Tab 5");
    assertThat(demoqaHome.getTabsContentTitle("Tab 5")).contains("Content 5 Title");

    demoqaHome.tabsLinkClick("Tab 3");
    assertThat(demoqaHome.getTabsContentTitle("Tab 3")).contains("Content 3 Title");
  }

  @Test
  public void clickOnIconsInFooter() {
    demoqaHome.clickOnFacebookIcon();
  }
}

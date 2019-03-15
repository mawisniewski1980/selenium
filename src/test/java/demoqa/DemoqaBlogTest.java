package demoqa;

import demoqablog.DemoqaBlog;
import enums.PageUrls.PageUrl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertEquals;


public class DemoqaBlogTest extends TestObject {


  private DemoqaBlog demoqaBlog;
  private DemoqaCommonElements commonElements;

  @BeforeTest
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaBlog = new DemoqaBlog(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.blogLinkClick();
  }

  @Test
  public void checkTitle() {
    assertEquals("Check Blog page title:", "Blog | Demoqa | Just another WordPress site", demoqaBlog.getTitle());
  }

  @Test
  public void checkEntrysTitle() {
    //assertTrue("Check titles of entry:",demoqaBlog.getEntryTitle().containsAll(ImmutableList.of("Sample Post", "Sample Post2")));
  }

  @Test
  public void clickTitleEntry() {
    demoqaBlog.clickTitleEntry("Sample Post");
    assertEquals("Check Sample Post page title:", "Sample Post | Demoqa", demoqaBlog.getTitle());
    assertEquals("Check titles of entry:", "Sample Post", commonElements.getEntryTitle());
  }

  @Test
  public void clickDateEntry() {
    demoqaBlog.clickDateEntry("Sample Post");
    assertEquals("Check Sample Post page title:", "Sample Post | Demoqa", demoqaBlog.getTitle());
    assertEquals("Check titles of entry:", "Sample Post", commonElements.getEntryTitle());
  }

  @Test
  public void clickImageEntry() {
    demoqaBlog.clickImageEntry("Sample Post2");
    assertEquals("Check Sample Post2 page title:", "Sample Post2 | Demoqa", demoqaBlog.getTitle());
    assertEquals("Check titles of entry:", "Sample Post2", commonElements.getEntryTitle());
  }

  @Test
  public void clickReadMoreLinkEntry() {
    demoqaBlog.clickReadMoreLinkEntry("Sample Post2");
    assertEquals("Check Sample Post2 page title:", "Sample Post2 | Demoqa", demoqaBlog.getTitle());
    assertEquals("Check titles of entry:", "Sample Post2", commonElements.getEntryTitle());
  }
}

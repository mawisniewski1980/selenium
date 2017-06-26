package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

import demoqablog.DemoqaBlog;
import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaBlogTest extends TestObject {

  private final Logger LOG = LoggerFactory.getLogger(DemoqaBlogTest.class);

  private DemoqaBlog demoqaBlog;
  private DemoqaNavbar demoqaNavbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaBlog = new DemoqaBlog(driver);
    demoqaNavbar = new DemoqaNavbar(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaNavbar.blogLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Blog | Demoqa | Just another WordPress site");
  }

  @Test
  public void getEntrysTitle() {
    assertThat(demoqaBlog.getEntryTitle()).containsAll(ImmutableList.of("Sample Post", "Sample Post2"));
  }

  @Test
  public void clickTitleEntry() {
    demoqaBlog.clickTitleEntry("Sample Post");
    assertThat(utils.getTitle()).isEqualTo("Sample Post | Demoqa");
    assertThat(commonElements.getEntryTitle()).isEqualTo("Sample Post");
  }

  @Test
  public void clickDateEntry() {
    demoqaBlog.clickDateEntry("Sample Post");
    assertThat(utils.getTitle()).isEqualTo("Sample Post | Demoqa");
    assertThat(commonElements.getEntryTitle()).isEqualTo("Sample Post");
  }

  @Test
  public void clickImageEntry() {
    demoqaBlog.clickImageEntry("Sample Post2");
    assertThat(utils.getTitle()).isEqualTo("Sample Post2 | Demoqa");
    assertThat(commonElements.getEntryTitle()).isEqualTo("Sample Post2");
  }

  @Test
  public void clickReadMoreLinkEntry() {
    demoqaBlog.clickReadMoreLinkEntry("Sample Post2");
    assertThat(utils.getTitle()).isEqualTo("Sample Post2 | Demoqa");
    assertThat(commonElements.getEntryTitle()).isEqualTo("Sample Post2");
  }
}

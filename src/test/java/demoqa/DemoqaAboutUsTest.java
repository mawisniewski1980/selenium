package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaAboutUsTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaAboutUsTest.class);

  // private DemoqaAboutUs demoqaAboutUs;
  private DemoqaNavbar demoqaNavbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    // demoqaAboutUs = new DemoqaAboutUs(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaNavbar = new DemoqaNavbar(driver);
    demoqaNavbar.aboutUsLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("About us | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("About us");
  }

}

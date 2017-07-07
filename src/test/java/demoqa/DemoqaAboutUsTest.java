package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaAboutUsTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaAboutUsTest.class);

  private DemoqaAboutUs demoqaAboutUs;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaAboutUs = new DemoqaAboutUs(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.aboutUsLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check About Us page title:", "About us | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
   assertEquals("Check About Us entry title:", "About us", commonElements.getEntryTitle());
  }

  @Test
  public void checkTextActicleOnAboutAssPageIfContainsSince() {
    assertTrue ("Check text in article :", demoqaAboutUs.getAboutAssText().contains ("since the 1500s"));
  }

}

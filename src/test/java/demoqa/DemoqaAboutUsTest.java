package demoqa;

import enums.PageUrls.PageUrl;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaAboutUsTest extends TestObject {



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

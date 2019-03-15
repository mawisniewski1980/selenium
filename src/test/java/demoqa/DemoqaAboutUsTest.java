package demoqa;

import enums.PageUrls.PageUrl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertEquals;


public class DemoqaAboutUsTest extends TestObject {

  private DemoqaAboutUs demoqaAboutUs;
  private DemoqaCommonElements commonElements;

  @BeforeTest
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaAboutUs = new DemoqaAboutUs(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.aboutUsLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check About Us page title:", "About us | Demoqa22", demoqaAboutUs.getTitle());
  }

  @Test
  public void checkEntryTitle() {
   assertEquals("Check About Us entry title:", "About us", commonElements.getEntryTitle());
  }

  @Test
  public void checkTextActicleOnAboutAssPageIfContainsSince() {
    //assertTrue ("Check text in article :", demoqaAboutUs.getAboutUsText().contains ("since the 1500s"));
  }

}

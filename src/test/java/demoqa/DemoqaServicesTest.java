package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaServicesTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaServicesTest.class);

  // private DemoqaServices demoqaServices;
  private DemoqaNavbar demoqaNavbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    // demoqaServices = new DemoqaServices(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaNavbar = new DemoqaNavbar(driver);
    demoqaNavbar.servicesLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Services | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Services");
  }
}

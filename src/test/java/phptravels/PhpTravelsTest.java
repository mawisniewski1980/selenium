package phptravels;

import enums.PageUrls.PageUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import testobject.OTest;




public class PhpTravelsTest extends OTest {

  private static final Logger LOG = LogManager.getLogger("PhpTravelsTest");

  // private PhpTravelsUserOPage ptup;

  @Before
  public void setTest() {
    setUrl(PageUrl.PHPTRAVELS_DEMO);
    // ptup = new PhpTravelsUserOPage(driver);
  }

}

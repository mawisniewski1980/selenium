package phptravels;

import enums.PageUrls.PageUrl;
import org.junit.Before;
import testobject.OTest;

public class PhpTravelsTest extends OTest {

  // private static final Logger LOG = LoggerFactory.getLogger(PhpTravelsTest.class.getName());

  // private PhpTravelsUserOPage ptup;

  @Before
  public void setTest() {
    setUrl(PageUrl.PHPTRAVELS_DEMO);
    // ptup = new PhpTravelsUserOPage(driver);
  }

}

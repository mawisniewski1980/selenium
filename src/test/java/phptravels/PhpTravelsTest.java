package phptravels;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls.PageUrl;
import phptravelsuserpage.PhpTravelsUserPage;
import testobject.TestObject;

public class PhpTravelsTest extends TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(PhpTravelsTest.class.getName());

  private PhpTravelsUserPage ptup;

  @Before
  public void setTest() {
    setUrl(PageUrl.PHPTRAVELS_DEMO);
    ptup = new PhpTravelsUserPage(driver);
  }

}

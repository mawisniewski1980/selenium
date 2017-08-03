package phptravels;

import enums.PageUrls.PageUrl;
import org.junit.Before;
import testobject.TestObject;




public class PhpTravelsTest extends TestObject {


  // private PhpTravelsUserPageObject ptup;

  @Before
  public void setTest() {
    setUrl(PageUrl.PHPTRAVELS_DEMO);
    // ptup = new PhpTravelsUserPageObject(driver);
  }

}

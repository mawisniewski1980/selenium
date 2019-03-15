package phptravels;

import enums.PageUrls.PageUrl;

import org.testng.annotations.BeforeTest;
import testobject.TestObject;




public class PhpTravelsTest extends TestObject {


  // private PhpTravelsUserPageObject ptup;

  @BeforeTest
  public void setTest() {
    setUrl(PageUrl.PHPTRAVELS_DEMO);
    // ptup = new PhpTravelsUserPageObject(driver);
  }

}

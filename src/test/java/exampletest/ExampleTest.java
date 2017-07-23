package exampletest;

import enums.PageUrls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;



import static org.junit.Assert.assertEquals;


public class ExampleTest extends OTest {

  private static final Logger LOG = LogManager.getLogger("ExampleTest");

  @Before
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertEquals("Onet.pl", driver.getTitle());
  }
}

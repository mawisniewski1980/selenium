package exampletest;

import enums.PageUrls;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;



import static org.junit.Assert.assertEquals;


public class ExampleTest extends OTest {

  private static final Logger LOG = Logger.getLogger(ExampleTest.class.getName());

  @Before
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertEquals("Onet.pl", driver.getTitle());
  }
}

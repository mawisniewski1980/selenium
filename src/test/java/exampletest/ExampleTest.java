package exampletest;

import enums.PageUrls;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;


public class ExampleTest extends TestObject {

  // private static final Logger LOG = LoggerFactory.getLogger(ExampleTest.class.getName());

  @Before
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertEquals("Onet.pl", driver.getTitle());
  }
}

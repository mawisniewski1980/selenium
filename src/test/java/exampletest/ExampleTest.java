package exampletest;

import enums.PageUrls;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;


public class ExampleTest extends TestObject {


  @Before
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertEquals("Onet.pl", driver.getTitle());
  }

  @Test
  public void scrollToBottom() {
    utils.getActions().scrollToBottom();
    utils.getWaits().waitTime(5);
  }

}

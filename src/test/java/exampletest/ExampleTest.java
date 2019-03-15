package exampletest;

import enums.PageUrls;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest extends TestObject {


  @BeforeTest
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertThat("Onet.pl").isEqualTo(driver.getTitle());
  }

  @Test
  public void scrollToBottom() {
    utils.getActions().scrollToBottom();
    utils.getWaits().waitTime(5);
  }

}

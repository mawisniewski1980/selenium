package exampletest;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls;
import testobject.TestObject;

public class ExampleTest extends TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(ExampleTest.class.getName());

  @Before
  public void setTest() {
    setUrl(PageUrls.PageUrl.ONET);
  }

  @Test
  public void openExamplePageTest() {
    assertThat(driver.getTitle()).isEqualTo("Onet.pl");
  }
}

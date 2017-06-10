package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaDraggableTest extends TestObject {

  private final Logger LOG = LoggerFactory.getLogger(DemoqaDraggableTest.class);

  private DemoqaDraggable draggable;
  private DemoqaNavbar navbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    navbar = new DemoqaNavbar(driver);
    commonElements = new DemoqaCommonElements(driver);
    draggable = new DemoqaDraggable(driver);
    navbar.draggableLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Draggable | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Draggable");
  }

}

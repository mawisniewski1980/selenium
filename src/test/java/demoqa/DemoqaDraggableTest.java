package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
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
  public void checkPageTitle() {
    assertEquals("Check Draggable page title:", "Draggable | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Draggable entry title:", "Draggable", commonElements.getEntryTitle());
  }

  @Test
  public void dragDefFuncDraggable() {

    commonElements.tabsLinkClick("Default functionality");

    Point position1 = draggable.getPositionDefFuncDraggable();
    LOG.info("Position 1 " + position1);

    draggable.dragDefFuncDraggable(200, 300);

    Point position2 = draggable.getPositionDefFuncDraggable();
    LOG.info("Position 2 " + position2);

    assertThat(position1).isNotEqualTo(position2);
  }

  @Test
  public void dragConstrainMovementConMovVertically() {

    commonElements.tabsLinkClick("Constrain movement");

    Point position1 = draggable.getPositionConMovVertically();
    LOG.info("Position 1 " + position1);

    draggable.dragConMovVertically(0, 100);

    Point position2 = draggable.getPositionConMovVertically();
    LOG.info("Position 2 " + position2);

    assertThat(position1).isNotEqualTo(position2);
  }

}

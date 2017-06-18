package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls.PageUrl;
import testobject.TestObject;
import utilsobjects.OInSpace;

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

  @Test
  public void dragDefFuncDraggable() {

    commonElements.tabsLinkClick("Default functionality");

    OInSpace position1 = draggable.getPositionDefFuncDraggable();
    LOG.info("Position 1 " + position1);

    draggable.dragDefFuncDraggable(200, 300);

    OInSpace position2 = draggable.getPositionDefFuncDraggable();
    LOG.info("Position 2 " + position2);

    assertThat(position1).isNotEqualTo(position2);
  }

  @Test
  public void dragConstrainMovementConMovVertically() {

    commonElements.tabsLinkClick("Constrain movement");

    OInSpace position1 = draggable.getPositionConMovVertically();
    LOG.info("Position 1 " + position1);

    draggable.dragConMovVertically(200, 300);

    OInSpace position2 = draggable.getPositionConMovVertically();
    LOG.info("Position 2 " + position2);

    assertThat(position1).isNotEqualTo(position2);
  }

  @Test
  public void xx() {
    commonElements.tabsLinkClick("Cursor style");

    LOG.info("Get position box1: " + draggable.getPositiondragCursorStyleBox1());
    LOG.info("Get position box2: " + draggable.getPositiondragCursorStyleBox2());
    draggable.getPositionxxx();
  }

}

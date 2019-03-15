package demoqa;

import enums.PageUrls.PageUrl;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class DemoqaDraggableTest extends TestObject {


  private DemoqaDraggable draggable;
  private DemoqaCommonElements commonElements;

  @BeforeTest
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    draggable = new DemoqaDraggable(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.draggableLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Draggable page title:", "Draggable | Demoqa", draggable.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Draggable entry title:", "Draggable", commonElements.getEntryTitle());
  }

  @Test
  public void dragDefFuncDraggable() {

    commonElements.tabsLinkClick("Default functionality");

    Point position1 = draggable.getPositionDefFuncDraggable();
    logger.info("Position 1 " + position1);

    draggable.dragDefFuncDraggable(200, 300);

    Point position2 = draggable.getPositionDefFuncDraggable();
    logger.info("Position 2 " + position2);

    assertNotEquals(position1, position2);
  }

  @Test
  public void dragConstrainMovementConMovVertically() {

    commonElements.tabsLinkClick("Constrain movement");

    Point position1 = draggable.getPositionConMovVertically();
    logger.info("Position 1 " + position1);

    draggable.dragConMovVertically(0, 100);

    Point position2 = draggable.getPositionConMovVertically();
    logger.info("Position 2 " + position2);

    assertNotEquals(position1, position2);
  }

}

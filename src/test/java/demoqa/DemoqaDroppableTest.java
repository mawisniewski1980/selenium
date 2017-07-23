package demoqa;

import enums.PageUrls.PageUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DemoqaDroppableTest extends OTest {

  private static final Logger LOG = LogManager.getLogger("DemoqaDroppableTest");

  private DemoqaDroppable droppable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    droppable = new DemoqaDroppable(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaMenu.droppableLinkClick();
  }

  @Test
  public void checkTitle() {
    assertEquals("Check Droppable page title:", "Droppable | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Droppable entry title:", "Droppable", commonElements.getEntryTitle());
  }

  @Test
  public void defaultFunctionalityDragMeToTargetInside() {
    commonElements.tabsLinkClick("Default functionality");

    droppable.check();

    // Point position1a = droppable.getPositionDefaultFunctionalistyDragMe();
    // Point position1b = droppable.getPositionDefaultFunctionalistyDropMe();

    assertEquals("Drop here", droppable.getDefaultFunctionalistyDropMeText());
    droppable.defaultFunctionalityDragAndDrop();
    assertEquals("Dropped!", droppable.getDefaultFunctionalistyDropMeText());

    // position1a = droppable.getPositionDefaultFunctionalistyDragMe();
    // position1b = droppable.getPositionDefaultFunctionalistyDropMe();

    droppable.check();
    // assertEquals(position1a.checkIfObjectIsInAnotherObject(position1b)).isTrue();
  }

  @Test
  public void defaultFunctionalityDragMeToTargetOutside() {

    commonElements.tabsLinkClick("Default functionality");
    assertEquals("Drop here", droppable.getDefaultFunctionalistyDropMeText());
    droppable.defaultFunctionalityDragAndDropBy(300, 100);
    assertEquals("Drop here", droppable.getDefaultFunctionalistyDropMeText());
  }

  @Test
  public void acceptDragMeToTargetNonValidAndValid() {

    commonElements.tabsLinkClick("Accept");
    assertEquals("accept: ‘#draggableaccept’", droppable.getAcceptDroppableText());
    droppable.acceptNonValidDragAndDrop();
    assertEquals("accept: ‘#draggableaccept’", droppable.getAcceptDroppableText());

    assertEquals("accept: ‘#draggableaccept’", droppable.getAcceptDroppableText());
    droppable.acceptValidDragAndDrop();
    assertEquals("Dropped!", droppable.getAcceptDroppableText());
  }

  @Test
  public void preventPropagationDragAndDropAll() {

    commonElements.tabsLinkClick("Prevent propagation");
    assertNotEquals("Drop here", droppable.getPreventPropagationDroppableInnerText());
    assertNotEquals("Drop here", droppable.getPreventPropagationDroppable2InnerText());
    assertNotEquals("Drop here", droppable.getPreventPropagationDroppableText());
    assertNotEquals("Drop here", droppable.getPreventPropagationDroppable2Text());

    droppable.preventPropagationDragAndDropAll();

    assertEquals("Dropped!", droppable.getPreventPropagationDroppableInnerText());
    assertEquals("Dropped!", droppable.getPreventPropagationDroppable2InnerText());
    assertEquals("Dropped!", droppable.getPreventPropagationDroppableText());
    assertEquals("Dropped!", droppable.getPreventPropagationDroppable2Text());
  }

  @Test
  public void revertDraggablePosition() {
    commonElements.tabsLinkClick("Revert draggable Position");

    assertEquals("Drop me here", droppable.getRevertDropablePositionText());

    droppable.revertDraggablePosition();

    assertEquals("Dropped!", droppable.getRevertDropablePositionText());
  }

  @Test
  public void shoppingCartDemo() {

    commonElements.tabsLinkClick("Shopping cart demo");

    assertEquals("Add your items here", droppable.getCartItemText());
    droppable.dragItemFromCartCatalogToCartItem("Bags", "Zebra Striped");
    assertEquals("Zebra Striped", droppable.getCartItemText());
  }
}

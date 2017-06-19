package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls.PageUrl;
import testobject.TestObject;
import utilsobjects.OInSpace;

public class DemoqaDroppableTest extends TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaDroppable.class.getName());

  private DemoqaDroppable droppable;
  private DemoqaPageMenu demoqaMenu;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    commonElements = new DemoqaCommonElements(driver);
    droppable = new DemoqaDroppable(driver);
    demoqaMenu = new DemoqaPageMenu(driver);
    demoqaMenu.droppableLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Droppable | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Droppable");
  }

  @Test
  public void defaultFunctionalityDragMeToTargetInside() {
    commonElements.tabsLinkClick("Default functionality");

    OInSpace position1a = droppable.getPositionDefaultFunctionalistyDragMe();
    OInSpace position1b = droppable.getPositionDefaultFunctionalistyDropMe();

    assertThat(position1a.checkIfObjectIsInAnotherObject(position1b)).isFalse();

    assertThat(droppable.getDefaultFunctionalistyDropMeText()).isEqualTo("Drop here");
    droppable.defaultFunctionalityDragAndDrop();
    assertThat(droppable.getDefaultFunctionalistyDropMeText()).isEqualTo("Dropped!");

    position1a = droppable.getPositionDefaultFunctionalistyDragMe();
    position1b = droppable.getPositionDefaultFunctionalistyDropMe();

    assertThat(position1a.checkIfObjectIsInAnotherObject(position1b)).isTrue();
  }

  @Test
  public void defaultFunctionalityDragMeToTargetOutside() {

    commonElements.tabsLinkClick("Default functionality");
    assertThat(droppable.getDefaultFunctionalistyDropMeText()).isEqualTo("Drop here");
    droppable.defaultFunctionalityDragAndDropBy(300, 100);
    assertThat(droppable.getDefaultFunctionalistyDropMeText()).isEqualTo("Drop here");
  }

  @Test
  public void acceptDragMeToTargetNonValidAndValid() {

    commonElements.tabsLinkClick("Accept");
    assertThat(droppable.getAcceptDroppableText()).isEqualTo("accept: ‘#draggableaccept’");
    droppable.acceptNonValidDragAndDrop();
    assertThat(droppable.getAcceptDroppableText()).isEqualTo("accept: ‘#draggableaccept’");

    assertThat(droppable.getAcceptDroppableText()).isEqualTo("accept: ‘#draggableaccept’");
    droppable.acceptValidDragAndDrop();
    assertThat(droppable.getAcceptDroppableText()).isEqualTo("Dropped!");
  }

  @Test
  public void preventPropagationDragAndDropAll() {

    commonElements.tabsLinkClick("Prevent propagation");
    assertThat(droppable.getPreventPropagationDroppableInnerText()).isNotEqualTo("Drop here");
    assertThat(droppable.getPreventPropagationDroppable2InnerText()).isNotEqualTo("Drop here");
    assertThat(droppable.getPreventPropagationDroppableText()).isNotEqualTo("Drop here");
    assertThat(droppable.getPreventPropagationDroppable2Text()).isNotEqualTo("Drop here");

    droppable.preventPropagationDragAndDropAll();

    assertThat(droppable.getPreventPropagationDroppableInnerText()).isEqualTo("Dropped!");
    assertThat(droppable.getPreventPropagationDroppable2InnerText()).isEqualTo("Dropped!");
    assertThat(droppable.getPreventPropagationDroppableText()).isEqualTo("Dropped!");
    assertThat(droppable.getPreventPropagationDroppable2Text()).isEqualTo("Dropped!");
  }

  @Test
  public void revertDraggablePosition() {
    commonElements.tabsLinkClick("Revert draggable Position");

    assertThat(droppable.getRevertDropablePositionText()).isEqualTo("Drop me here");

    droppable.revertDraggablePosition();

    assertThat(droppable.getRevertDropablePositionText()).isEqualTo("Dropped!");
  }

  @Test
  public void shoppingCartDemo() {

    commonElements.tabsLinkClick("Shopping cart demo");

    assertThat(droppable.getCartItemText()).isEqualTo("Add your items here");
    droppable.dragItemFromCartCatalogToCartItem("Bags", "Zebra Striped");
    assertThat(droppable.getCartItemText()).isEqualTo("Zebra Striped");
  }
}

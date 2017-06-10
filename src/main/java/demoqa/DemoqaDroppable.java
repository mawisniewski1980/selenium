package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;
import utilsobjects.ODraggable;

public class DemoqaDroppable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaDroppable.class.getName());

  public DemoqaDroppable(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalistyDragMeCss = "#draggableview";
  @FindBy(css = defaultFunctionalistyDragMeCss)
  private WebElement defaultFunctionalistyDragMe;

  private final String defaultFunctionalistyDropMeCss = "#droppableview";
  @FindBy(css = defaultFunctionalistyDropMeCss)
  private WebElement defaultFunctionalistyDropMe;

  private final String defaultFunctionalistyDropMeTextCss = "#droppableview p";
  @FindBy(css = defaultFunctionalistyDropMeTextCss)
  private WebElement defaultFunctionalistyDropMeText;

  private final String acceptNonValidCss = "#draggable-nonvalid";
  @FindBy(css = acceptNonValidCss)
  private WebElement acceptNonValid;

  private final String acceptDragableCss = "#draggableaccept";
  @FindBy(css = acceptDragableCss)
  private WebElement acceptDragable;

  private final String acceptDroppableCss = "#droppableaccept";
  @FindBy(css = acceptDroppableCss)
  private WebElement acceptDroppable;

  private final String acceptDroppableTextCss = "#droppableaccept p";
  @FindBy(css = acceptDroppableTextCss)
  private WebElement acceptDroppableText;

  private final String preventPropagationDraggableCss = "#draggableprop";
  @FindBy(css = preventPropagationDraggableCss)
  private WebElement preventPropagationDraggable;

  private final String preventPropagationDroppableCss = "#droppableprop";
  @FindBy(css = preventPropagationDroppableCss)
  private WebElement preventPropagationDroppable;

  private final String preventPropagationDroppableTextCss = "#droppableprop>p";
  @FindBy(css = preventPropagationDroppableTextCss)
  private WebElement preventPropagationDroppableText;

  private final String preventPropagationDroppableInnerCss = "#droppable-inner";
  @FindBy(css = preventPropagationDroppableInnerCss)
  private WebElement preventPropagationDroppableInner;

  private final String preventPropagationDroppableInnerTextCss = "#droppable-inner>p";
  @FindBy(css = preventPropagationDroppableInnerTextCss)
  private WebElement preventPropagationDroppableInnerText;

  private final String preventPropagationDroppable2Css = "#droppableprop2";
  @FindBy(css = preventPropagationDroppable2Css)
  private WebElement preventPropagationDroppable2;

  private final String preventPropagationDroppable2TextCss = "#droppableprop2>p";
  @FindBy(css = preventPropagationDroppable2TextCss)
  private WebElement preventPropagationDroppable2Text;

  private final String preventPropagationDroppable2InnerCss = "#droppable2-inner";
  @FindBy(css = preventPropagationDroppable2InnerCss)
  private WebElement preventPropagationDroppable2Inner;

  private final String preventPropagationDroppable2InnerTextCss = "#droppable2-inner>p";
  @FindBy(css = preventPropagationDroppable2InnerTextCss)
  private WebElement preventPropagationDroppable2InnerText;

  private final String revertDraggablePositionCss = "#draggablerevert";
  @FindBy(css = revertDraggablePositionCss)
  private WebElement revertDraggablePosition;

  private final String revertDraggablePosition2Css = "#draggablerevert2";
  @FindBy(css = revertDraggablePosition2Css)
  private WebElement revertDraggablePosition2;

  private final String revertDropablePositionCss = "#droppablerevert";
  @FindBy(css = revertDropablePositionCss)
  private WebElement revertDropablePosition;

  private final String productCatalogCss = "#products #catalog";
  @FindBy(css = productCatalogCss)
  private List<WebElement> productCatalog;

  private final String productCatalogCategoryCss = "#products #catalog h2";
  @FindBy(css = productCatalogCategoryCss)
  private List<WebElement> productCatalogCategory;

  private final String productCatalogCategoryItemsCss = "#products #catalog li";
  @FindBy(css = productCatalogCategoryItemsCss)
  private List<WebElement> productCatalogCategoryItems;

  private final String cartCss = "#cart div";
  @FindBy(css = cartCss)
  private WebElement cart;

  private final String cartItemCss = "#cart div li";
  @FindBy(css = cartItemCss)
  private WebElement cartItem;

  public String getDefaultFunctionalistyDropMeText() {
    return defaultFunctionalistyDropMeText.getText();
  }

  public void defaultFunctionalityDragAndDrop() {
    utils.dragAndDrop(defaultFunctionalistyDragMe, defaultFunctionalistyDropMe);
  }

  public void defaultFunctionalityDragAndDropBy(int xOffset, int yOffset) {
    utils.dragAndDropByOffset(defaultFunctionalistyDragMe, xOffset, yOffset);
  }

  public String getAcceptDroppableText() {
    return acceptDroppableText.getText();
  }

  public void acceptNonValidDragAndDrop() {
    utils.dragAndDrop(acceptNonValid, acceptDroppable);
  }

  public void acceptValidDragAndDrop() {
    utils.dragAndDrop(acceptDragable, acceptDroppable);
  }

  public String getPreventPropagationDroppableText() {
    return preventPropagationDroppableText.getText();
  }

  public String getPreventPropagationDroppableInnerText() {
    return preventPropagationDroppableInnerText.getText();
  }

  public String getPreventPropagationDroppable2Text() {
    return preventPropagationDroppable2Text.getText();
  }

  public String getPreventPropagationDroppable2InnerText() {
    return preventPropagationDroppable2InnerText.getText();
  }

  public void preventPropagationDragAndDropAll() {

    ODraggable drag = new ODraggable(preventPropagationDraggable);
    ODraggable drop = new ODraggable(preventPropagationDroppable);

    // utils.dragAndDropCenterToCenter(drag, drop);
    // utils.dragAndDropLeftToLeft(drag, drop);
    // utils.dragAndDropTopRightToTopRight(drag, drop);
    // utils.dragAndDropDownRightToDownRight(drag, drop);
    // utils.dragAndDropDownLeftToDownLeft(drag, drop);
    utils.elementIsNotVisibleOnScreen(preventPropagationDraggable);

    utils.waitTime(5);

  }
}

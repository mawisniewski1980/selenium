package demoqa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;
import utilsobjects.ODraggable;

import java.util.List;



public class DemoqaDroppable extends OPage {

  private static final Logger LOG = LogManager.getLogger("DemoqaDroppable");

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

  private final String preventPropagationDraggableContenerCss = "#tabs-3";
  @FindBy(css = preventPropagationDraggableContenerCss)
  private WebElement preventPropagationDraggableContener;

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

  private final String revertDraggablePositionContenerCss = "#tabs-4";
  @FindBy(css = revertDraggablePositionContenerCss)
  private WebElement revertDraggablePositionContener;

  private final String revertDraggablePosition2Css = "#draggablerevert2";
  @FindBy(css = revertDraggablePosition2Css)
  private WebElement revertDraggablePosition2;

  private final String revertDropablePositionCss = "#droppablerevert";
  @FindBy(css = revertDropablePositionCss)
  private WebElement revertDropablePosition;

  private final String revertDropablePositionTextCss = "#droppablerevert>p";
  @FindBy(css = revertDropablePositionTextCss)
  private WebElement revertDropablePositionText;

  private final String productCatalogCss = "#products #catalog";
  @FindBy(css = productCatalogCss)
  private WebElement productCatalog;

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
    utils.getActions().dragAndDrop(new ODraggable(defaultFunctionalistyDragMe), new ODraggable(defaultFunctionalistyDropMe));
  }

  public Point getPositionDefaultFunctionalistyDragMe() {
    return new ODraggable(defaultFunctionalistyDragMe).getRectangle().getPoint();
  }

  public Point getPositionDefaultFunctionalistyDropMe() {
    return new ODraggable(defaultFunctionalistyDropMe).getRectangle().getPoint();
  }

  public void check() {
    utils.getActions().checkIfElementIsInAnotherElement(new ODraggable(defaultFunctionalistyDragMe), new ODraggable(defaultFunctionalistyDropMe));
  }

  public void defaultFunctionalityDragAndDropBy(int xOffset, int yOffset) {
    utils.getActions().dragAndDropByOffset(new ODraggable(defaultFunctionalistyDragMe), xOffset, yOffset);
  }

  public String getAcceptDroppableText() {
    return acceptDroppableText.getText();
  }

  public void acceptNonValidDragAndDrop() {
    utils.getActions().dragAndDrop(new ODraggable(acceptNonValid), new ODraggable(acceptDroppable));
  }

  public void acceptValidDragAndDrop() {
    utils.getActions().dragAndDrop(new ODraggable(acceptDragable), new ODraggable(acceptDroppable));
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

  public String getRevertDropablePositionText() {
    return revertDropablePositionText.getText();
  }

  public void preventPropagationDragAndDropAll() {

    ODraggable drag = new ODraggable(preventPropagationDraggable);
    ODraggable outDrop = new ODraggable(preventPropagationDroppable);
    ODraggable outDrop2 = new ODraggable(preventPropagationDroppable2);
    ODraggable innerDrop = new ODraggable(preventPropagationDroppableInner);
    ODraggable innerDrop2 = new ODraggable(preventPropagationDroppable2Inner);
    ODraggable contener = new ODraggable(preventPropagationDraggableContener.findElement(By.cssSelector(".inside_contain")));

    utils.getActions().moveElementFromTopLeftToTopLeft(drag, outDrop)
        .moveElementFromTopLeftToTopLeft(drag, outDrop2)
        .moveElementFromTopLeftToTopLeft(drag, innerDrop)
        .moveElementFromTopLeftToTopLeft(drag, innerDrop2)
        .moveElementFromTopLeftToTopLeft(drag, contener);
  }

  public Point getRevertDraggablePosition() {
    return new ODraggable(revertDraggablePosition).getRectangle().getPoint();
  }

  public Point getRevertDraggablePosition2() {
    return new ODraggable(revertDraggablePosition2).getRectangle().getPoint();
  }

  public Point getRevertDropablePosition() {
    return new ODraggable(revertDropablePosition).getRectangle().getPoint();
  }

  public void revertDraggablePosition() {

    ODraggable drag = new ODraggable(revertDraggablePosition);
    ODraggable drag2 = new ODraggable(revertDraggablePosition2);
    ODraggable drop = new ODraggable(revertDropablePosition);
    // ODraggable contener = new ODraggable(revertDraggablePositionContener.findElement(By.cssSelector(".inside_contain")));

    Point oDragPositionBefore = drag.getRectangle().getPoint();
    Point oDrag2PositionBefore = drag2.getRectangle().getPoint();
    Point oDropPositionBefore = drop.getRectangle().getPoint();

    utils.getActions().moveElementFromCenterToCenter(drag, drop);
    utils.getActions().moveElementFromCenterToCenter(drag2, drop);
    utils.getWaits().waitUntilAnimationStop(drag);

    Point oDragPositionAfter = drag.getRectangle().getPoint();
    Point oDrag2PositionAfter = drag2.getRectangle().getPoint();
    Point oDropPositionAfter = drop.getRectangle().getPoint();

    //assertThat(oDragPositionBefore).isEqualsToByComparingFields(oDragPositionAfter);
    //assertThat(oDrag2PositionBefore).isNotEqualTo(oDrag2PositionAfter);
    //assertThat(oDropPositionBefore).isEqualsToByComparingFields(oDropPositionAfter);
  }

  public String getCartItemText() {
    return cartItem.getText();
  }

  public DemoqaDroppable openClickCartCatalog(String title) {

    LOG.info("Open Catalog cart by title: " + title);
    int index = utils.getId(productCatalogCategory, title);
    productCatalogCategory.get(index).click();
    List<WebElement> listCatalogItems = productCatalog.findElement(By.id(productCatalogCategory.get(index).getAttribute("aria-controls"))).findElements(By.tagName("li"));
    utils.getWaits().waitForVisibilityOfElements(listCatalogItems);
    return this;
  }

  public DemoqaDroppable dragItemFromCartCatalogToCartItem(String catalogTitle, String itemTitle) {
    openClickCartCatalog(catalogTitle);

    LOG.info("Drag " + itemTitle + " from catalog " + catalogTitle + " to cart");
    int index = utils.getId(productCatalogCategory, catalogTitle);
    List<WebElement> listCatalogItems = productCatalog.findElement(By.id(productCatalogCategory.get(index).getAttribute("aria-controls"))).findElements(By.tagName("li"));
    utils.getWaits().waitForVisibilityOfElements(listCatalogItems);
    int index2 = utils.getId(listCatalogItems, itemTitle);
    WebElement listCatalogItem = productCatalog.findElement(By.id(productCatalogCategory.get(index).getAttribute("aria-controls"))).findElements(By.tagName("li")).get(index2);
    utils.getActions().moveElementFromCenterToCenter(new ODraggable(listCatalogItem), new ODraggable(cart));
    return this;
  }

}

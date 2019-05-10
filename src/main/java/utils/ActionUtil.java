package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class ActionUtil {

  private static final Logger LOG = LoggerFactory.getLogger(ActionUtil.class);

  private WebDriver driver;
  private Actions actions;

  public ActionUtil(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
  }

  public Actions getActions() {
    return actions;
  }

  public ActionUtil dragAndDrop(Draggable drag, Draggable drop) {
    LOG.info("Drag element " + drag.getCenter() + " to " + drop.getCenter());
    actions.dragAndDrop(drag.getElement(), drop.getElement());
    actions.build().perform();
    return this;
  }

  public ActionUtil dragAndDropByOffset(Draggable drag, int xOffset, int yOffset) {
    LOG.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(drag.getElement(), xOffset, yOffset);
    actions.build().perform();
    return this;
  }

  public ActionUtil moveByX(Draggable drag, int xOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveByY(Draggable drag, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveByXY(Draggable drag, int xOffset, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveTo(Draggable drag) {
    actions.moveToElement(drag.getElement());
    actions.build().perform();
    return this;
  }

  public ActionUtil moveTo(WebElement element) {
    actions.moveToElement(element);
    actions.build().perform();
    return this;
  }

  public ActionUtil moveElementFromCenterToCenter(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveElementFromTopLeftToTopLeft(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), 0, 0).clickAndHold().moveToElement(drop.getElement(), 0, 0).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveElementFromTopRightToTopRight(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), 0).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), 0).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveElementFromDownRightToDownRight(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveElementFromDownLeftToDownLeft(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), 0, drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), 0, drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public ActionUtil moveByXYWithWait(Draggable drag, int xOffset, int yOffset, int wait) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset);
    actions.release().build().perform();
    return this;
  }

  public ActionUtil selectFromCenterToCenter(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public int getDistanceBetweenCenterToCenter(Draggable drag, Draggable drop) {
    double dx = drag.getCenter().getX() - drop.getCenter().getX();
    double dy = drag.getCenter().getY() - drop.getCenter().getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

  // TODO
  public boolean checkIfElementIsInAnotherElement(Draggable drag, Draggable drop) {

    System.out.println("Point obj1 " + drag.getX() + " " + drag.getY());
    System.out.println("Point obj2 " + drop.getX() + " " + drop.getY());

    System.out.println("Width/height obj1 " + drag.getWidth() + " " + drag.getHeight());
    System.out.println("Width/height obj2 " + drop.getWidth() + " " + drop.getHeight());
    /*
     * if ( (obj1.getX() > obj2.getX()) && (obj1.getY() > obj2.getY()) && obj1.getWidth() < obj2.getWidth() && ) return true;
     */

    return false;
  }

  public ActionUtil scrollToBottom() {
    LOG.info("Scroll to bottom");
    //((JavascriptExecutor) getDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
    return this;
  }

  public ActionUtil scrollTo(WebElement element) {
    LOG.info("Scroll to element " + element.getLocation());
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    return this;
  }

  public ActionUtil scrollToElement(WebElement element) {
    Draggable obj = new Draggable(element);
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + obj.getCenter().getX() + "," + (obj.getCenter().getY() - 200) + ");");
    return this;
  }



}

package utilsobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class Actions {

  Logger logger = LoggerFactory.getLogger(getClass());


  private WebDriver driver;
  private org.openqa.selenium.interactions.Actions actions;

  public Actions(WebDriver driver) {
    this.driver = driver;
    this.actions = new org.openqa.selenium.interactions.Actions(driver);
  }

  public Actions dragAndDrop(Draggable drag, Draggable drop) {
    logger.info("Drag element " + drag.getCenter() + " to " + drop.getCenter());
    actions.dragAndDrop(drag.getElement(), drop.getElement());
    actions.build().perform();
    return this;
  }

  public Actions dragAndDropByOffset(Draggable drag, int xOffset, int yOffset) {
    logger.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(drag.getElement(), xOffset, yOffset);
    actions.build().perform();
    return this;
  }

  public Actions moveByX(Draggable drag, int xOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    return this;
  }

  public Actions moveByY(Draggable drag, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    return this;
  }

  public Actions moveByXY(Draggable drag, int xOffset, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    return this;
  }

  public Actions moveTo(Draggable drag) {
    actions.moveToElement(drag.getElement());
    actions.build().perform();
    return this;
  }

  public Actions moveTo(WebElement element) {
    actions.moveToElement(element);
    actions.build().perform();
    return this;
  }

  public Actions moveElementFromCenterToCenter(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public Actions moveElementFromTopLeftToTopLeft(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), 0, 0).clickAndHold().moveToElement(drop.getElement(), 0, 0).release();
    actions.build().perform();
    return this;
  }

  public Actions moveElementFromTopRightToTopRight(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), 0).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), 0).release();
    actions.build().perform();
    return this;
  }

  public Actions moveElementFromDownRightToDownRight(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public Actions moveElementFromDownLeftToDownLeft(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), 0, drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), 0, drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public Actions moveByXYWithWait(Draggable drag, int xOffset, int yOffset, int wait) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset);
    new Utils(driver).getWaits().waitTime(wait);
    actions.release().build().perform();
    return this;
  }

  public Actions selectFromCenterToCenter(Draggable drag, Draggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public Actions selectItemByClick(List<WebElement> elements, String title) {
    elements.get(new Utils(driver).getId(elements, title)).click();
    return this;
  }

  public Actions selectItemByClickWithCTRL(List<WebElement> elements, List<String> titles) {
    actions.keyDown(Keys.LEFT_CONTROL);
    for (String text : titles) {
      actions.click(elements.get(new Utils(driver).getId(elements, text)));
    }
    actions.keyUp(Keys.CONTROL).build().perform();
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

  public Actions scrollToBottom() {
    // logger.info("Scroll to bottom");
    //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
    return this;
  }

  public Actions scrollTo(WebElement element) {
    // logger.info("Scroll to element " + element.getLocation());
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    return this;
  }

  public Actions scrollToElement(WebElement element) {
    Draggable obj = new Draggable(element);
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + obj.getCenter().getX() + "," + (obj.getCenter().getY() - 150) + ");");
    return this;
  }

  public Waits waitTime(long time) {
    return new Waits(driver).waitTime(time);
  }

  public Actions switchToDefaultContent(){
    driver.switchTo().defaultContent();
    new Waits(driver).waitForPageLoad();
    return this;
  }

  public Actions switchToDefaultWindow(){
    driver.switchTo().window(driver.getWindowHandle());
    new Waits(driver).waitForPageLoad();
    return this;
  }

  public Actions switchToNextWindow() {
    switchToDefaultWindow();
    for(String nextWindow : driver.getWindowHandles()){
      driver.switchTo().window(nextWindow);
    }
    new Waits(driver).waitForPageLoad();
    return this;
  }
}

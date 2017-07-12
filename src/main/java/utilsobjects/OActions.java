package utilsobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OActions {

  private static final Logger LOG = LoggerFactory.getLogger(OActions.class.getName());

  private WebDriver driver;
  private Actions actions;

  public OActions(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
  }

  public OActions dragAndDrop(ODraggable drag, ODraggable drop) {
    LOG.info("Drag element " + drag.getCenter() + " to " + drop.getCenter());
    actions.dragAndDrop(drag.getElement(), drop.getElement());
    actions.build().perform();
    return this;
  }

  public OActions dragAndDropByOffset(ODraggable drag, int xOffset, int yOffset) {
    LOG.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(drag.getElement(), xOffset, yOffset);
    actions.build().perform();
    return this;
  }

  public OActions moveByX(ODraggable drag, int xOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    return this;
  }

  public OActions moveByY(ODraggable drag, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OActions moveByXY(ODraggable drag, int xOffset, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OActions moveTo(ODraggable drag) {
    actions.moveToElement(drag.getElement());
    actions.build().perform();
    return this;
  }

  public OActions moveTo(WebElement element) {
    actions.moveToElement(element);
    actions.build().perform();
    return this;
  }

  public OActions moveElementFromCenterToCenter(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public OActions moveElementFromTopLeftToTopLeft(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), 0, 0).clickAndHold().moveToElement(drop.getElement(), 0, 0).release();
    actions.build().perform();
    return this;
  }

  public OActions moveElementFromTopRightToTopRight(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), 0).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), 0).release();
    actions.build().perform();
    return this;
  }

  public OActions moveElementFromDownRightToDownRight(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public OActions moveElementFromDownLeftToDownLeft(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), 0, drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), 0, drop.getHeight()).release();
    actions.build().perform();
    return this;
  }

  public OActions moveByXYWithWait(ODraggable drag, int xOffset, int yOffset, int wait) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset);
    new OUtils(driver).waits.waitTime(wait);
    actions.release().build().perform();
    return this;
  }

  public OActions selectFromCenterToCenter(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    return this;
  }

  public OActions selectItemByClick(List<WebElement> elements, String title) {
    elements.get(new OUtils(driver).getId(elements, title)).click();
    return this;
  }

  public OActions selectItemByClickWithCTRL(List<WebElement> elements, List<String> titles) {
    actions.keyDown(Keys.LEFT_CONTROL);
    for (String text : titles) {
      actions.click(elements.get(new OUtils(driver).getId(elements, text)));
    }
    actions.keyUp(Keys.CONTROL).build().perform();
    return this;
  }

  public int getDistanceBetweenCenterToCenter(ODraggable drag, ODraggable drop) {
    double dx = drag.getCenter().getX() - drop.getCenter().getX();
    double dy = drag.getCenter().getY() - drop.getCenter().getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

  // TODO
  public boolean checkIfElementIsInAnotherElement(ODraggable drag, ODraggable drop) {

    System.out.println("Point obj1 " + drag.getX() + " " + drag.getY());
    System.out.println("Point obj2 " + drop.getX() + " " + drop.getY());

    System.out.println("Width/height obj1 " + drag.getWidth() + " " + drag.getHeight());
    System.out.println("Width/height obj2 " + drop.getWidth() + " " + drop.getHeight());
    /*
     * if ( (obj1.getX() > obj2.getX()) && (obj1.getY() > obj2.getY()) && obj1.getWidth() < obj2.getWidth() && ) return true;
     */

    return false;
  }

  /**
   * Scrolling web page with Selenium Webdriver using java https://www.seleniumeasy.com/selenium-tutorials/scrolling-web-page-with-selenium-webdriver-using-java
   */
  public OActions scrollToBottom() {
    // LOG.info("Scroll to bottom");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    return this;
  }

  public OActions scrollTo(WebElement element) {
    // LOG.info("Scroll to element " + element.getLocation());
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    return this;
  }

  public OActions scrollToElement(WebElement element) {
    ODraggable obj = new ODraggable(element);
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + obj.getCenter().getX() + "," + (obj.getCenter().getY() - 150) + ");");
    return this;
  }

  public OWaits waitTime(long time) {
    return new OWaits(driver).waitTime(time);
  }

  public OActions switchToDefaultContent(){
    driver.switchTo().defaultContent();
    new OWaits(driver).waitForPageLoad();
    return this;
  }

  public OActions switchToDefaultWindow(){
    driver.switchTo().window(driver.getWindowHandle());
    new OWaits(driver).waitForPageLoad();
    return this;
  }

  public OActions switchToNextWindow() {
    switchToDefaultWindow();
    for(String nextWindow : driver.getWindowHandles()){
      driver.switchTo().window(nextWindow);
    }
    new OWaits(driver).waitForPageLoad();
    return this;
  }
}

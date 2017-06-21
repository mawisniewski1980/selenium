package utilsobjects;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.fest.assertions.api.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OUtils {

  private static final Logger LOG = LoggerFactory.getLogger(OUtils.class.getName());

  private WebDriver driver;
  private WebDriverWait webDriverWait;
  private Actions actions;

  public OUtils(WebDriver driver) {
    this.driver = driver;
    this.webDriverWait = new WebDriverWait(driver, 15);
    this.actions = new Actions(driver);
  }

  public String startDate() {
    LocalDateTime date = LocalDateTime.now();
    return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
  }

  public String endDate() {
    LocalDateTime date2 = LocalDateTime.now();
    return date2.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
  }

  public void waitForVisibilityOfElement(WebElement element) {
    webDriverWait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForVisibilityOfElements(List<WebElement> elements) {
    webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
  }

  public void waitForVisibilityOfElement(By locator) {
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void waitForVisibilityOfElements(By locator) {
    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }

  public WebElement findNextElementByCssSelector(WebElement element, By locator) {
    return element.findElement(locator);
  }

  public WebElement findNextElementByCssSelector(WebElement element, String locator) {
    return element.findElement(By.cssSelector(locator));
  }

  public List<WebElement> findNextElementsByCssSelector(WebElement element, By locator) {
    return element.findElements(locator);
  }

  public List<WebElement> findNextElementsByCssSelector(WebElement element, String locator) {
    return element.findElements(By.cssSelector(locator));
  }

  public boolean isElementPresent(By locator) {
    return driver.findElement(locator).isDisplayed();
  }

  public boolean isElementsPresent(By locator) {
    return driver.findElements(locator).size() != 0;
  }

  public boolean isElementPresent(WebElement element) {
    return element.isDisplayed();
  }

  public boolean isElementsPresent(List<WebElement> elements) {
    return elements.size() != 0;
  }

  public boolean isElementEnabled(By locator) {
    return driver.findElement(locator).isEnabled();
  }

  public boolean isElementSelected(By locator) {
    return driver.findElement(locator).isSelected();
  }

  public boolean isElementEnabled(WebElement element) {
    return element.isEnabled();
  }

  public boolean isElementSelected(WebElement element) {
    return element.isSelected();
  }

  /**
   * http://www.testingexcellence.com/webdriver-wait-page-load-example-java/
   */
  public void waitForPageLoad() {
    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
      }
    };
    webDriverWait.until(pageLoadCondition);
  }

  public OUtils waitTime(long timeout) {
    try {
      LOG.info("Wait: " + timeout + " seconds");
      TimeUnit.SECONDS.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public void waitUntilAnimationStop(WebElement element) {
    Dimension state = null;
    Dimension stateCheck = null;
    do {
      state = element.getSize();
      stateCheck = element.getSize();
      waitTime(1);
    } while (!stateCheck.equals(state));
  }

  public void waitUntilAnimationStop(ODraggable element) {
    Dimension state = null;
    Dimension stateCheck = null;
    do {
      state = element.getRectangle().getDimension();
      stateCheck = element.getRectangle().getDimension();
      waitTime(1);
    } while (!stateCheck.equals(state));
  }

  public String getTitle() {
    LOG.info("Title of page: " + driver.getTitle());
    return driver.getTitle();
  }

  public List<String> getStringsFromWebElements(List<WebElement> elements) {
    List<String> listStrings = new ArrayList<String>();
    if (elements.size() > 0) {
      for (WebElement el : elements) {
        listStrings.add(el.getText());
      }
    } else {
      Fail.fail("List of WebElements is empty.");
    }
    return listStrings;
  }

  public String getText(WebElement element) {
    LOG.info("Get text from element.");
    if (isElementPresent(element))
      scrollToElement(element);
    else {
      Fail.fail("Element is not present");
    }
    return element.getText();
  }

  public void setText(WebElement element, String text) {
    LOG.info("Set text " + text);
    scrollToElement(element);
    element.clear();
    element.sendKeys(text);
  }

  public Integer getId(List<WebElement> elements, String title) {
    int index = -1;

    if (elements.size() > 0) {
      waitForVisibilityOfElements(elements);
      for (int i = 0; i < elements.size(); i++) {
        if (elements.get(i).getText().equals(title)) {
          index = i;
          // LOG.info("Index of " + title + " is " + index);
          return index;
        }
      }
    } else {
      Fail.fail("The list of webelements is empty.");
    }
    return index;
  }

  public OUtils dragAndDrop(ODraggable drag, ODraggable drop) {
    LOG.info("Drag element " + drag.getCenter() + " to " + drop.getCenter());
    actions.dragAndDrop(drag.getElement(), drop.getElement());
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropByOffset(ODraggable drag, int xOffset, int yOffset) {
    LOG.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(drag.getElement(), xOffset, yOffset);
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveByX(ODraggable drag, int xOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveByY(ODraggable drag, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveByXY(ODraggable drag, int xOffset, int yOffset) {
    actions.moveToElement(drag.getElement()).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromCenterToCenter(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromTopLeftToTopLeft(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), 0, 0).clickAndHold().moveToElement(drop.getElement(), 0, 0).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromTopRightToTopRight(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), 0).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), 0).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromDownRightToDownRight(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getWidth(), drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getWidth(), drop.getHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromDownLeftToDownLeft(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), 0, drag.getHeight()).clickAndHold().moveToElement(drop.getElement(), 0, drop.getHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils moveElementFromTopLeftToTopLeftWithOffset(ODraggable drag, int x1, int y1, ODraggable drop, int x2, int y2) {
    actions.moveToElement(drag.getElement(), x1, y1).clickAndHold().moveToElement(drop.getElement(), x2, y2).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils selectFromCenterToCenter(ODraggable drag, ODraggable drop) {
    actions.moveToElement(drag.getElement(), drag.getHalfWidth(), drag.getHalfHeight()).clickAndHold().moveToElement(drop.getElement(), drop.getHalfWidth(), drop.getHalfHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils selectItemByClick(List<WebElement> elements, String title) {
    elements.get(getId(elements, title)).click();
    waitTime(1);
    return this;
  }

  public OUtils selectItemByClickWithCTRL(List<WebElement> elements, List<String> titles) {
    actions.keyDown(Keys.LEFT_CONTROL);
    for (String text : titles) {
      actions.click(elements.get(getId(elements, text)));
    }
    actions.keyUp(Keys.CONTROL).build().perform();
    waitTime(1);
    return this;
  }

  public int getDistanceBetweenCenterToCenter(ODraggable drag, ODraggable drop) {
    double dx = drag.getCenter().getX() - drop.getCenter().getX();
    double dy = drag.getCenter().getY() - drop.getCenter().getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

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
  public OUtils scrollToBottom() {
    // LOG.info("Scroll to bottom");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    return this;
  }

  public OUtils scrollTo(WebElement element) {
    // LOG.info("Scroll to element " + element.getLocation());
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    return this;
  }

  public OUtils scrollToElement(WebElement element) {
    ODraggable obj = new ODraggable(element);
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + obj.getCenter().getX() + "," + (obj.getCenter().getY() - 150) + ");");
    return this;
  }

  public String generateRandomText(int length, int spaces) {

    Random rand = new Random();
    String str = RandomStringUtils.randomAlphanumeric(length);
    StringBuilder sb = new StringBuilder(str);
    int randNumber = rand.nextInt(length);
    for (int i = 0; i < spaces; i++) {
      randNumber = rand.nextInt(length);
      sb.insert(randNumber, " ");
    }

    str = sb.toString();
    WordUtils.capitalize(str);
    return str;
  }

  public String generateRandomNumber(int length) {
    String str = RandomStringUtils.randomNumeric(length);
    return str;
  }

  public void linkClick(List<WebElement> elementList, String title) {
    LOG.info("Click on link by title: " + title);
    scrollToElement(elementList.get(getId(elementList, title)));
    elementList.get(getId(elementList, title)).click();
  }

  public void linkClick(List<WebElement> elementList, int index) {
    LOG.info("Click on link by index: " + index);
    scrollToElement(elementList.get(index));
    elementList.get(index).click();
  }

  public void linkClick(WebElement element) {
    LOG.info("Click on link");
    scrollToElement(element).waitTime(1);
    element.click();
  }

  public String getImgExampleFile(String fileName) {
    LOG.info("Get example file " + fileName);
    String path = System.getProperty("user.dir") + "\\img\\";
    return path + fileName;
  }

  public void takeScreenShoot(String testName) {

    String path = "C:\\seleniumTest\\";
    String fileName = testName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss")) + ".png";

    try {
      File screenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenShoot, new File(path + fileName));

    } catch (IOException e) {
      LOG.info("Cannot copy " + fileName + " to: " + path);
      // e.printStackTrace();
    }
  }
}

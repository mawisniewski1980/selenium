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
import org.openqa.selenium.Point;
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
    if (isElementPresent(element))
      scrollToElement(element);
    else {
      Fail.fail("Element is not present");
    }
    return element.getText();
  }

  public void setText(WebElement element, String text) {
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

  public OUtils dragAndDrop(WebElement drag, WebElement drop) {
    LOG.info("Drag element " + drag.getLocation() + " to " + drop.getLocation());
    actions.dragAndDrop(drag, drop);
    actions.build().perform();
    return this;
  }

  public OUtils dragAndDrop(Point point1, Point point2) {
    LOG.info("Drag element by point " + point1 + " to " + point2);
    actions.moveByOffset(point1.getX(), point1.getY()).clickAndHold().moveByOffset(point2.getX(), point2.getY()).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragAndDropByOffset(WebElement element, int xOffset, int yOffset) {
    LOG.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(element, xOffset, yOffset);
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragByX(WebElement element, int xOffset) {
    actions.moveToElement(element).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragByY(WebElement element, int yOffset) {
    actions.moveToElement(element).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragByXY(WebElement element, int xOffset, int yOffset) {
    actions.moveToElement(element).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragAndDropByOffset(ODraggable obj, int xOffset, int yOffset) {
    LOG.info("Drag element by offset " + "(" + xOffset + "," + yOffset + ")");
    actions.dragAndDropBy(obj.getElement(), xOffset, yOffset);
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragByX(ODraggable obj, int xOffset) {
    actions.moveToElement(obj.getElement()).clickAndHold().moveByOffset(xOffset, 0).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragByY(ODraggable obj, int yOffset) {
    actions.moveToElement(obj.getElement()).clickAndHold().moveByOffset(0, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragByXY(ODraggable obj, int xOffset, int yOffset) {
    actions.moveToElement(obj.getElement()).clickAndHold().moveByOffset(xOffset, yOffset).release();
    actions.build().perform();
    return this;
  }

  public OUtils dragAndDropCenterToCenter(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), obj1.getHalfWidth(), obj1.getHalfHeight()).clickAndHold().moveToElement(obj2.getElement(), obj2.getHalfWidth(), obj2.getHalfHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropTopLeftToTopLeft(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), 0, 0).clickAndHold().moveToElement(obj2.getElement(), 0, 0).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropTopRightToTopRight(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), obj1.getWidth(), 0).clickAndHold().moveToElement(obj2.getElement(), obj2.getWidth(), 0).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropDownRightToDownRight(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), obj1.getWidth(), obj1.getHeight()).clickAndHold().moveToElement(obj2.getElement(), obj2.getWidth(), obj2.getHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropDownLeftToDownLeft(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), 0, obj1.getHeight()).clickAndHold().moveToElement(obj2.getElement(), 0, obj2.getHeight()).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils dragAndDropTopLeftToTopLeftWithOffset(ODraggable obj1, int x1, int y1, ODraggable obj2, int x2, int y2) {
    actions.moveToElement(obj1.getElement(), x1, y1).clickAndHold().moveToElement(obj2.getElement(), x2, y2).release();
    actions.build().perform();
    waitTime(1);
    return this;
  }

  public OUtils selectFromCenterToCenter(ODraggable obj1, ODraggable obj2) {
    actions.moveToElement(obj1.getElement(), obj1.getHalfWidth(), obj1.getHalfHeight()).clickAndHold().moveToElement(obj2.getElement(), obj2.getHalfWidth(), obj2.getHalfHeight()).release();
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

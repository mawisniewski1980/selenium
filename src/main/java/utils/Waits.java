package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;



public class Waits {

  private static final Logger LOG = LoggerFactory.getLogger(Waits.class);

  private WebDriverWait waits;

  public Waits(WebDriver driver) {
    this.waits = new WebDriverWait(driver, 15);
  }

  public Waits waitForVisibilityOfElement(WebElement element) {
    waits.until(ExpectedConditions.visibilityOf(element));
    return this;
  }

  public Waits waitForVisibilityOfElements(List<WebElement> elements) {
    waits.until(ExpectedConditions.visibilityOfAllElements(elements));
    return this;
  }

  public Waits waitForVisibilityOfElement(By locator) {
    waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return this;
  }

  public Waits waitForVisibilityOfElements(By locator) {
    waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    return this;
  }

  /**
   * http://www.testingexcellence.com/webdriver-wait-page-load-example-java/
   */
  public Waits waitForPageLoad() {
    LOG.info("Wait for page load finish.");
    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
      }
    };
    waits.until(pageLoadCondition);
    return this;
  }

  public Waits waitTime(long timeout) {
    try {
      LOG.info("Wait: " + timeout + " seconds");
      TimeUnit.SECONDS.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public Waits waitUntilAnimationStop(Draggable element) {
    Dimension state = null;
    Dimension stateCheck = null;
    do {
      state = element.getRectangle().getDimension();
      stateCheck = element.getRectangle().getDimension();
      waitTime(1);
    } while (!stateCheck.equals(state));
    return this;
  }
}

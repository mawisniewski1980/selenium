package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class WaitUtil {

  private static final Logger LOG = LoggerFactory.getLogger(WaitUtil.class);

  private Wait waits;

  public WaitUtil(WebDriver driver) {
    this.waits = configWebDriverWait(driver, 20);
  }

  private Wait configWebDriverWait(WebDriver driver, long timeout) {
    return new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(timeout))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);
  }

  public Wait getWait() {
    return waits;
  }

  public WaitUtil waitForVisibilityOfElement(WebElement element) {
    waits.until(ExpectedConditions.visibilityOf(element));
    return this;
  }

  public WaitUtil waitForVisibilityOfElements(List<WebElement> elements) {
    waits.until(ExpectedConditions.visibilityOfAllElements(elements));
    return this;
  }

  public WaitUtil waitForVisibilityOfElement(By locator) {
    waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return this;
  }

  public WaitUtil waitForVisibilityOfElements(By locator) {
    waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    return this;
  }

  public WaitUtil waitForPageLoad() {
    LOG.info("Wait for page load finish.");
    ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    waits.until(pageLoadCondition);
    return this;
  }

  public WaitUtil waitTime(long timeout) {
    try {
      LOG.info("Wait: " + timeout + " seconds");
      TimeUnit.SECONDS.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public WaitUtil waitUntilAnimationStop(Draggable element) {
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

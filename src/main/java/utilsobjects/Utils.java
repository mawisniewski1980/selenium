package utilsobjects;

import logs.LogsUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Utils {

  Logger logger = LoggerFactory.getLogger(getClass());

  private WebDriver driver;
  private Waits waits;
  private Actions actions;
  private LogsUtils logsUtils;

  public Utils(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    this.waits = new Waits(driver);
    this.logsUtils = new LogsUtils(driver);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public Waits getWaits() {
    return waits;
  }

  public Actions getActions() {
    return actions;
  }

  public LogsUtils getLogs() {
    return logsUtils;
  }

  public String getInfoAboutSystem() {
    return "[Java " + System.getProperty("java.version") + "][" + System.getProperty("os.name") + ", " + System.getProperty("os.version") + ", " + System.getProperty("os.arch") + "]";
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
    try {
      driver.findElement(locator).isDisplayed();
      return true;
    } catch (NoSuchElementException e) {
      //TODO
    }
    return false;
  }

  public boolean isElementsPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public boolean isElementPresent(WebElement element) {
    return element.isDisplayed();
  }


  public boolean isElementActive(WebElement element) {
    return element.getAttribute("class").contains("active");
  }

  public List<String> getTextFromWebElementList(List<WebElement> elements) {
    List<String> listStrings = new ArrayList<>();
    if (elements.size() > 0) {
      for (WebElement el : elements) {
        listStrings.add(el.getText());
      }
    } else {
      //fail("List of WebElements is empty.");
    }
    return listStrings;
  }

  public String getText(WebElement element) {
    logger.info("Get text from element.");
    if (isElementPresent(element))
      actions.scrollToElement(element);
    else {
      //fail("Element is not present");
    }
    return element.getText();
  }

  public Utils setText(WebElement element, String text) {
    setText(element,text,true);
    return this;
  }

  public Utils setText(WebElement element, String text, boolean clearField) {
    logger.info("Set text " + text);
    actions.scrollToElement(element);
    if(clearField) element.clear();
    element.sendKeys(text);
    return this;
  }

  public int getId(List<WebElement> elements, String title) {
    int index = -1;

    if (elements.size() > 0) {
      waits.waitForVisibilityOfElements(elements);
      for (int i = 0; i < elements.size(); i++) {
        if (elements.get(i).getText().equals(title)) {
          index = i;
          // logger.info("Index of " + title + " is " + index);
          return index;
        }
      }
    } else {
      //fail("The list of webelements is empty.");
    }
    return index;
  }

  public String generateRandomAlphabeticWithSpaces(int length, int spaces) {
    Random rand = new Random();
    String str = RandomStringUtils.randomAlphabetic(length);
    StringBuilder sb = new StringBuilder(str);
    int randNumber = rand.nextInt(length);
    for (int i = 0; i < spaces; i++) {
      randNumber = rand.nextInt(length);
      sb.insert(randNumber, " ");
    }
    return WordUtils.capitalize(sb.toString());
  }

  public String generateRandomAlphanumeric(int legth) {
    return RandomStringUtils.randomAlphanumeric(legth);
  }

  public String generateRandomNumeric(int length) {
    return RandomStringUtils.randomNumeric(length);
  }

  public String generateRandomAscii(int legth) {
    return RandomStringUtils.randomAscii(legth);
  }

  public Utils linkClick(List<WebElement> elementList, String title) {
    logger.info("Click on link by title: " + title);
    actions.scrollToElement(elementList.get(getId(elementList, title)));
    elementList.get(getId(elementList, title)).click();
    return this;
  }

  public Utils linkClick(WebElement element) {
    logger.info("Click on link " + element.getText());
    actions.scrollToElement(element);
    element.click();
    return this;
  }

  public Utils hightLightElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: blue; border: 2px solid blue;");
    return this;
  }

  public Utils zoomInToElement(WebElement element) {
    element.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    return this;
  }

  public Utils zoomOutFromElement(WebElement element) {
    element.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
    return this;
  }

  public Utils zoomReset() {
    driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    return this;
  }

  public String getImgExampleFile(String fileName) {
    logger.info("Get example file " + fileName);
    String path = System.getProperty("user.dir") + "\\img\\";
    return path + fileName;
  }


}

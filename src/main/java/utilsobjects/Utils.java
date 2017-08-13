package utilsobjects;

import logs.LogsUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

  private WebDriver driver;
  private Waits waits;
  private Actions actions;
  private LogsUtils logs;

  public Utils(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    this.waits = new Waits(driver);
    this.logs = new LogsUtils(driver);
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
    return logs;
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
      //Fail.fail("List of WebElements is empty.");
    }
    return listStrings;
  }

  public String getText(WebElement element) {
    //LOG.info("Get text from element.");
    if (isElementPresent(element))
      actions.scrollToElement(element);
    else {
      //Fail.fail("Element is not present");
    }
    return element.getText();
  }

  public Utils setText(WebElement element, String text) {
    //LOG.info("Set text " + text);
    actions.scrollToElement(element);
    element.clear();
    element.sendKeys(text);
    return this;
  }

  public Utils setText(WebElement element, String text, boolean clearField) {
    //LOG.info("Set text " + text);
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
          // //LOG.info("Index of " + title + " is " + index);
          return index;
        }
      }
    } else {
      //Fail.fail("The list of webelements is empty.");
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

  public void linkClick(List<WebElement> elementList, String title) {
    //LOG.info("Click on link by title: " + title);
    actions.scrollToElement(elementList.get(getId(elementList, title)));
    elementList.get(getId(elementList, title)).click();
  }

  public Utils linkClick(WebElement element) {
    //LOG.info("Click on link " + element.getText());
    actions.scrollToElement(element);
    element.click();
    return this;
  }

  public String getImgExampleFile(String fileName) {
    //LOG.info("Get example file " + fileName);
    String path = System.getProperty("user.dir") + "\\img\\";
    return path + fileName;
  }


}

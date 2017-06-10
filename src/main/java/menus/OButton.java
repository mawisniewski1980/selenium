package menus;

import org.fest.assertions.api.Fail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class OButton extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(OButton.class.getName());

  private WebElement webElement;

  public OButton(WebDriver driver, WebElement webElement) {
    super(driver);
    this.webElement = setCheckedWebElement(webElement);
  }

  protected WebElement setCheckedWebElement(WebElement webElement) {
    // LOG.info("WebElement has an attribute = button");
    if (webElement.getTagName().equals("button")) {
      return webElement;
    }

    Fail.fail("WebElement has not an attribute = button");
    return null;
  }

  private Boolean isButtonIsActive() {
    if (this.webElement.getAttribute("class").contains("active")) {
      // LOG.info("Webelement is active");
      return true;
    }
    return false;
  }

  private Boolean isButtonDisplayed() {
    // LOG.info("Webelement is displayed");
    return this.webElement.isDisplayed();
  }

  public String getText() {
    return this.webElement.getText();
  }

  public void click() {

    utils.scrollToElement(this.webElement);

    if (isButtonDisplayed() && !isButtonIsActive()) {
      LOG.info("Click [" + this.webElement.getText() + "] button.");
      this.webElement.click();
    }
  }

}

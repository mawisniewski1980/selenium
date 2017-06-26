package demoqacontact;

import org.fest.assertions.api.Fail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import menus.OLink;
import pageobject.PageObject;

public class DemoqaContact extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaContact.class.getName());

  public DemoqaContact(WebDriver driver) {
    super(driver);
  }

  private final String nameInputCss = "input[name='your-name']";
  @FindBy(css = nameInputCss)
  private WebElement nameInput;

  private final String emailInputCss = "input[name='your-email']";
  @FindBy(css = emailInputCss)
  private WebElement emailInput;

  private final String subjectInputCss = "input[name='your-subject']";
  @FindBy(css = subjectInputCss)
  private WebElement subjectInput;

  private final String messageInputCss = "textarea[name='your-message']";
  @FindBy(css = messageInputCss)
  private WebElement messageInput;

  private final String sendButtonCss = "input[value='Send'][type='submit']";
  @FindBy(css = sendButtonCss)
  private WebElement sendButton;

  private final String allertMessageCss = "form div[role='alert']";
  @FindBy(css = allertMessageCss)
  private WebElement allertMessage;

  private final String nameNotValidTipCss = "span.your-name span[role='alert']";
  @FindBy(css = nameNotValidTipCss)
  private WebElement nameNotValidTip;

  private final String emailNotValidTipCss = "span.your-email span[role='alert']";
  @FindBy(css = emailNotValidTipCss)
  private WebElement emailNotValidTip;

  public void setNameInput(String name) {
    LOG.info("Set [Your Name (required)]: " + name);
    nameInput.click();
    nameInput.clear();
    nameInput.sendKeys(name);
  }

  public void setEmailInput(String email) {
    LOG.info("Set [Your Email (required)]: " + email);
    emailInput.click();
    emailInput.clear();
    emailInput.sendKeys(email);
  }

  public void setSubjectInput(String subject) {
    LOG.info("Set [Subject]: " + subject);
    subjectInput.click();
    subjectInput.clear();
    subjectInput.sendKeys(subject);
  }

  public void setMessageInput(String message) {
    LOG.info("Set [Your Message]: " + message);
    messageInput.click();
    messageInput.clear();
    messageInput.sendKeys(message);
  }

  public void clickSendButton() {
    LOG.info("Set [Send] button");
    new OLink(driver, sendButton).click();
  }

  public void fillContactForm(DemoqaContactForm dcform) {
    LOG.info("Fill contact form.");

    if (dcform != null) {

      if (dcform.getName() != null) {
        setNameInput(dcform.getName());
      }

      if (dcform.getEmail() != null) {
        setEmailInput(dcform.getEmail());
      }

      if (dcform.getSubject() != null) {
        setSubjectInput(dcform.getSubject());
      }

      if (dcform.getMessage() != null) {
        setMessageInput(dcform.getMessage());
      }

    } else {
      Fail.fail("Object Demoqa Contact Form is not set. Demoqa Contact Form is null");
    }
  }

  public Boolean allertMessageOk() {
    LOG.info("Message confirmation after sended mail. OK.");
    utils.waitForVisibilityOfElement(allertMessage);
    if (allertMessage.getAttribute("class").contains("sent-ok"))
      return true;
    return false;
  }

  public Boolean allertMessageFail() {
    LOG.info("Message confirmation after sended mail. Fail.");
    utils.waitForVisibilityOfElement(allertMessage);
    if (allertMessage.getAttribute("class").contains("validation-errors"))
      return true;
    return false;
  }

  public String getAllertMessageOk() {
    LOG.info("Get allert message. OK.");
    String strNull = null;

    if (allertMessageOk()) {
      strNull = allertMessage.getText();
      LOG.info("Message: " + strNull);
      return strNull;
    }

    return strNull;
  }

  public String getAllertMessageFail() {
    LOG.info("Get allert message. Fail.");
    String strNull = null;

    if (allertMessageFail()) {
      strNull = allertMessage.getText();
      LOG.info("Message: " + strNull);
      return strNull;
    }

    return strNull;
  }

  public String getTextValidationNameField() {
    LOG.info("Get text validation. Your Name input field: " + nameNotValidTip.getText());
    return nameNotValidTip.getText();
  }

  public String getTextValidationEmailField() {
    LOG.info("Get text validation. Email input field: " + emailNotValidTip.getText());
    return emailNotValidTip.getText();
  }

}

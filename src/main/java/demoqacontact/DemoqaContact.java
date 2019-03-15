package demoqacontact;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;




public class DemoqaContact extends PageObject {


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
    logger.info("Set [Your Name (required)]: " + name);
    nameInput.click();
    nameInput.clear();
    nameInput.sendKeys(name);
  }

  public void setEmailInput(String email) {
    logger.info("Set [Your Email (required)]: " + email);
    emailInput.click();
    emailInput.clear();
    emailInput.sendKeys(email);
  }

  public void setSubjectInput(String subject) {
    logger.info("Set [Subject]: " + subject);
    subjectInput.click();
    subjectInput.clear();
    subjectInput.sendKeys(subject);
  }

  public void setMessageInput(String message) {
    logger.info("Set [Your Message]: " + message);
    messageInput.click();
    messageInput.clear();
    messageInput.sendKeys(message);
  }

  public void clickSendButton() {
    logger.info("Set [Send] button");
    utils.linkClick(sendButton);
  }

  public void fillContactForm(DemoqaContactForm dcform) {
    logger.info("Fill contact form.");

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
    }
  }

  public Boolean alertMessageOk() {
    logger.info("Message confirmation after sended mail. OK.");
    utils.getWaits().waitForVisibilityOfElement(allertMessage);
    return allertMessage.getAttribute("class").contains("sent-ok");
  }

  public Boolean alertMessageFail() {
    logger.info("Message confirmation after sended mail. Fail.");
    utils.getWaits().waitForVisibilityOfElement(allertMessage);
    return allertMessage.getAttribute("class").contains("validation-errors");
  }

  public String getAlertMessageOk() {
    logger.info("Get alert message. OK.");
    String strNull = null;

    if (alertMessageOk()) {
      strNull = allertMessage.getText();
      logger.info("Message: " + strNull);
      return strNull;
    }

    return strNull;
  }

  public String getAlertMessageFail() {
    logger.info("Get alert message. Fail.");
    String strNull = null;

    if (alertMessageFail()) {
      strNull = allertMessage.getText();
      logger.info("Message: " + strNull);
      return strNull;
    }

    return strNull;
  }

  public String getTextValidationNameField() {
    logger.info("Get text validation. Your Name input field: " + nameNotValidTip.getText());
    return nameNotValidTip.getText();
  }

  public String getTextValidationEmailField() {
    logger.info("Get text validation. Email input field: " + emailNotValidTip.getText());
    return emailNotValidTip.getText();
  }

}

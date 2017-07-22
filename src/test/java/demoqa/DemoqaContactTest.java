package demoqa;

import demoqacontact.DemoqaContact;
import demoqacontact.DemoqaContactForm;
import enums.DemoqaEnums.DemoqaContactValidationFormText;
import enums.DemoqaEnums.DemoqaContactValidationInputText;
import enums.PageUrls.PageUrl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;

import java.util.Arrays;
import java.util.List;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoqaContactTest extends OTest {

  private static final Logger LOG = Logger.getLogger(DemoqaContactTest.class.getName());

  private DemoqaContact demoqacontact;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqacontact = new DemoqaContact(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.contactLinkClick();
  }

  @Test
  public void checkTitle() {
    assertEquals("Check Contact page title:", "Contact | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Contact page entry title:", "Contact", commonElements.getEntryTitle());
  }

  @Test
  public void fillAllFieldsAndSendFormCheckMessageOk() {

    String name = "Name " + utils.generateRandomAlphabeticWithSpaces(15, 0);
    String email = "email@o2.com";
    String subject = "Subject " + utils.generateRandomAlphabeticWithSpaces(25, 3);
    String message = "Message " + utils.generateRandomAlphabeticWithSpaces(250, 9);
    DemoqaContactForm cform = new DemoqaContactForm(name, email, subject, message);
    demoqacontact.fillContactForm(cform);
    demoqacontact.clickSendButton();
    assertTrue("Check if there is an alert massage ok.", demoqacontact.alertMessageOk());
    assertEquals("Your message was sent successfully. Thanks.", DemoqaContactValidationFormText.SUCCESS.getText(), demoqacontact.getAlertMessageOk());
  }

  @Test
  public void fillAllFieldsAndSendFormCheckMessageFail() {

    DemoqaContactForm cform = new DemoqaContactForm("", "emailxx.com", "", "");
    demoqacontact.fillContactForm(cform);
    demoqacontact.clickSendButton();
    assertTrue("Message confirmation after sended mail. Fail.", demoqacontact.alertMessageFail());
    assertEquals("Validation errors occurred. Please confirm the fields and submit it again.", DemoqaContactValidationFormText.ERROR.getText(), demoqacontact.getAlertMessageFail());
  }

  @Test
  public void checkValidationRequireNameAndEmailInputField() {

    demoqacontact.clickSendButton();

    assertEquals(DemoqaContactValidationInputText.REQUIREFIELD.getText(), demoqacontact.getTextValidationNameField());
    assertEquals(DemoqaContactValidationInputText.REQUIREFIELD.getText(), demoqacontact.getTextValidationEmailField());
    assertTrue("Message confirmation after sended mail. Fail.", demoqacontact.alertMessageFail());
    assertEquals("Validation errors occurred. Please confirm the fields and submit it again.", DemoqaContactValidationFormText.ERROR.getText(), demoqacontact.getAlertMessageFail());
  }

  @Test
  public void checkValidationEmailField() {

    String name = "Name " + utils.generateRandomAlphabeticWithSpaces(15, 0);
    String validEmail = "email@o2.com";
    String subject = "Subject " + utils.generateRandomAlphabeticWithSpaces(25, 4);
    String message = "Message " + utils.generateRandomAlphabeticWithSpaces(260, 10);
    demoqacontact.setNameInput(name);
    demoqacontact.setSubjectInput(subject);
    demoqacontact.setMessageInput(message);

    /*
     * .email@example.com, email.@example.com, email..email@example.com, Abc..123@example.com - with this examples page have big problem email@example.web, email@111.222.333.44444 - this emails - are
     * correct on email field :(
     */
    List<String> invalidEmails = Arrays.asList("www", "ww@", "qww 3 @.", "plainaddress", "#@%^%#$@#$@#.com", "@example.com", "Joe Smith <email@example.com>", "email.example.com",
        "email@example@example.com", "あいうえお@example.com", "email@example.com (Joe Smith)", "email@example", "email@-example.com", "email@example..com", "just\"not\"right@example.com",
        "this is\"really\"not\\allowed@example.com");

    for (String invalidEmail : invalidEmails) {
      LOG.info("Get email: " + invalidEmail);
      demoqacontact.setEmailInput(invalidEmail);
      demoqacontact.clickSendButton();
      assertTrue("Message confirmation after sended mail. Fail.", demoqacontact.alertMessageFail());
      assertEquals(DemoqaContactValidationFormText.ERROR.getText(), demoqacontact.getAlertMessageFail());
      assertEquals(DemoqaContactValidationInputText.INVALIDEMAIL.getText(), demoqacontact.getTextValidationEmailField());
    }

    demoqacontact.setEmailInput(validEmail);
    demoqacontact.clickSendButton();
    assertTrue("Check if there is an alert massage ok.", demoqacontact.alertMessageOk());
    assertEquals(DemoqaContactValidationFormText.SUCCESS.getText(), demoqacontact.getAlertMessageOk());
  }

}

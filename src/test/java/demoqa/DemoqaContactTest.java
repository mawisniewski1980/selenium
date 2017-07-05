package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demoqacontact.DemoqaContact;
import demoqacontact.DemoqaContactForm;
import enums.DemoqaEnums.DemoqaContactValidationFormText;
import enums.DemoqaEnums.DemoqaContactValidationInputText;
import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaContactTest extends TestObject {

  private final Logger LOG = LoggerFactory.getLogger(DemoqaContactTest.class);

  private DemoqaContact demoqacontact;
  private DemoqaNavbar demoqaNavbar;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaNavbar = new DemoqaNavbar(driver);
    demoqacontact = new DemoqaContact(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaNavbar.contactLinkClick();
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
    assertThat(demoqacontact.allertMessageOk()).isTrue();
    assertThat(demoqacontact.getAllertMessageOk()).isEqualTo(DemoqaContactValidationFormText.SUCCESS.getText());
  }

  @Test
  public void fillAllFieldsAndSendFormCheckMessageFail() {

    DemoqaContactForm cform = new DemoqaContactForm("", "emailxx.com", "", "");
    demoqacontact.fillContactForm(cform);
    demoqacontact.clickSendButton();
    assertThat(demoqacontact.allertMessageFail()).isTrue();
    assertThat(demoqacontact.getAllertMessageFail()).isEqualTo(DemoqaContactValidationFormText.ERROR.getText());
  }

  @Test
  public void checkValidationRequireNameAndEmailInputField() {

    demoqacontact.clickSendButton();

    assertThat(demoqacontact.getTextValidationNameField()).isEqualTo(DemoqaContactValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqacontact.getTextValidationEmailField()).isEqualTo(DemoqaContactValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqacontact.allertMessageFail()).isTrue();
    assertThat(demoqacontact.getAllertMessageFail()).isEqualTo(DemoqaContactValidationFormText.ERROR.getText());
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

    /**
     * .email@example.com, email.@example.com, email..email@example.com, Abc..123@example.com - with this examples page have big problem email@example.web, email@111.222.333.44444 - this emails - are
     * correct on email field :(
     */
    List<String> invalidEmails = Arrays.asList("www", "ww@", "qww 3 @.", "plainaddress", "#@%^%#$@#$@#.com", "@example.com", "Joe Smith <email@example.com>", "email.example.com",
        "email@example@example.com", "あいうえお@example.com", "email@example.com (Joe Smith)", "email@example", "email@-example.com", "email@example..com", "just\"not\"right@example.com",
        "this is\"really\"not\\allowed@example.com");

    for (int i = 0; i < invalidEmails.size(); i++) {
      LOG.info("Get email: " + invalidEmails.get(i));
      demoqacontact.setEmailInput(invalidEmails.get(i));
      demoqacontact.clickSendButton();
      assertThat(demoqacontact.allertMessageFail()).isTrue();
      assertThat(demoqacontact.getAllertMessageFail()).isEqualTo(DemoqaContactValidationFormText.ERROR.getText());
      assertThat(demoqacontact.getTextValidationEmailField()).isEqualTo(DemoqaContactValidationInputText.INVALIDEMAIL.getText());
    }

    demoqacontact.setEmailInput(validEmail);
    demoqacontact.clickSendButton();
    assertThat(demoqacontact.allertMessageOk()).isTrue();
    assertThat(demoqacontact.getAllertMessageOk()).isEqualTo(DemoqaContactValidationFormText.SUCCESS.getText());
  }

}

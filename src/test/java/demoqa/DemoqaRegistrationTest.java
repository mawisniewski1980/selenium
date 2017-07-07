package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import demoqaregistration.DemoqaRegistration;
import demoqaregistration.DemoqaRegistrationForm;
import enums.DemoqaEnums.DemoqaRegistrationFormText;
import enums.DemoqaEnums.DemoqaRegistrationHobby;
import enums.DemoqaEnums.DemoqaRegistrationMaritalStatus;
import enums.DemoqaEnums.DemoqaRegistrationValidationInputText;
import enums.DemoqaEnums.DemoqaReistrationCountry;
import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaRegistrationTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaRegistrationTest.class);

  private DemoqaRegistration demoqaReg;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaReg = new DemoqaRegistration(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaMenu.registrationLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Registration page title:", "Registration | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Registration entry title:", "Registration", commonElements.getEntryTitle());
  }

  @Test
  public void checkAllRequireFieldText() {
    demoqaReg.clickSubmit();
    assertThat(demoqaReg.getFirstLastNameRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getHobbyRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getPhoneRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getUserRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getEmailRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getPasswordRequired()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
    assertThat(demoqaReg.getConfirmPasswordRequiredText()).isEqualTo(DemoqaRegistrationValidationInputText.REQUIREFIELD.getText());
  }

  @Test
  public void fillAllFieldsConfirmRegistrationTextOK() {

    String firstName = utils.generateRandomAlphabeticWithSpaces(10, 0);
    String lastName = utils.generateRandomAlphabeticWithSpaces(15, 1);
    DemoqaRegistrationMaritalStatus maritalStatus = DemoqaRegistrationMaritalStatus.MARRIED;
    DemoqaRegistrationHobby hobby = DemoqaRegistrationHobby.DANCE;
    DemoqaReistrationCountry country = DemoqaReistrationCountry.AZERBAIJAN;
    LocalDate dateofBirth = LocalDate.of(1980, 1, 8);
    String phone = "48" + utils.generateRandomNumeric(10);
    String userName = utils.generateRandomAlphabeticWithSpaces(10, 0);
    String email = utils.generateRandomAlphabeticWithSpaces(15, 0) + "@xx.xx";
    String yourProfilePicture = utils.getImgExampleFile("star.png");
    String aboutYourself = utils.generateRandomAlphabeticWithSpaces(150, 7);
    String password = "Passw0rd!";
    String confirmPassword = password;

    DemoqaRegistrationForm dRegForm = new DemoqaRegistrationForm(firstName, lastName, maritalStatus, hobby, country, dateofBirth, phone, userName, email, yourProfilePicture,
        aboutYourself, password, confirmPassword);

    demoqaReg.fillRegistrationForm(dRegForm);

    // utils.takeScreenShoot(testName.getMethodName());

    demoqaReg.clickSubmit();

    assertThat(demoqaReg.getConfirmRegistrationTextOk()).isEqualTo(DemoqaRegistrationFormText.THANKYOU.getText());
  }

}

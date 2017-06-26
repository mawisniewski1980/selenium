package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

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
  private DemoqaPageMenu demoqaMenu;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaReg = new DemoqaRegistration(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaMenu = new DemoqaPageMenu(driver);
    demoqaMenu.registrationLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Registration | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Registration");
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

    String firstName = utils.generateRandomText(10, 0);
    String lastName = utils.generateRandomText(15, 1);
    DemoqaRegistrationMaritalStatus maritalStatus = DemoqaRegistrationMaritalStatus.MARRIED;
    DemoqaRegistrationHobby hobby = DemoqaRegistrationHobby.DANCE;
    DemoqaReistrationCountry country = DemoqaReistrationCountry.AZERBAIJAN;
    LocalDate dateofBirth = LocalDate.of(1980, 1, 8);
    String phone = "48" + utils.generateRandomNumber(10);
    String userName = utils.generateRandomText(10, 0);
    String email = utils.generateRandomText(15, 0) + "@xx.xx";
    String yourProfilePicture = utils.getImgExampleFile("star.png");
    String aboutYourself = utils.generateRandomText(150, 7);
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

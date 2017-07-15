package demoqaregistration;

import enums.DemoqaEnums.DemoqaRegistrationHobby;
import enums.DemoqaEnums.DemoqaRegistrationMaritalStatus;
import enums.DemoqaEnums.DemoqaReistrationCountry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.OPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DemoqaRegistration extends OPage {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaRegistration.class.getName());

  public DemoqaRegistration(WebDriver driver) {
    super(driver);
  }

  private final String confirmRegistrationOkCss = ".piereg_message";
  @FindBy(css = confirmRegistrationOkCss)
  private WebElement confirmRegistrationOk;

  private final String loginErrorCss = ".piereg_login_error";
  @FindBy(css = loginErrorCss)
  private WebElement loginError;

  private final String passwordStrengthCss = "#piereg_passwordStrength";
  @FindBy(css = passwordStrengthCss)
  private WebElement passwordStrength;

  private final String firstNameCss = "#name_3_firstname";
  @FindBy(css = firstNameCss)
  private WebElement firstName;

  private final String lastNameCss = "#name_3_lastname";
  @FindBy(css = lastNameCss)
  private WebElement lastName;

  private final String firstLastNameRequiredCss = ".fields:nth-of-type(1) span.error";
  @FindBy(css = firstLastNameRequiredCss)
  private WebElement firstLastNameRequiredText;

  private final String maritalRadioCss = "input[type='radio']";
  @FindBy(css = maritalRadioCss)
  private List<WebElement> maritalRadio;

  private final String hobbyCheckboxCss = "input[type='checkbox']";
  @FindBy(css = hobbyCheckboxCss)
  private List<WebElement> hobbyCheckbox;

  private final String hobbyRequiredCss = ".fields:nth-of-type(3) span.error";
  @FindBy(css = hobbyRequiredCss)
  private WebElement hobbyRequiredText;

  private final String countrySelectCss = "select#dropdown_7";
  @FindBy(css = countrySelectCss)
  private WebElement countrySelect;

  private final String dateOfBirthMonthCss = "select[name*='[mm]']";
  @FindBy(css = dateOfBirthMonthCss)
  private WebElement dateOfBirthMonth;

  private final String dateOfBirthDayCss = "select[name*='[dd]']";
  @FindBy(css = dateOfBirthDayCss)
  private WebElement dateOfBirthDay;

  private final String dateOfBirthYearCss = "select[name*='[yy]']";
  @FindBy(css = dateOfBirthYearCss)
  private WebElement dateOfBirthYear;

  private final String phoneCss = "#phone_9";
  @FindBy(css = phoneCss)
  private WebElement phone;

  private final String phoneRequiredCss = ".fields:nth-of-type(6) span.error";
  @FindBy(css = phoneRequiredCss)
  private WebElement phoneRequiredText;

  private final String userNameCss = "#username";
  @FindBy(css = userNameCss)
  private WebElement userName;

  private final String userRequiredCss = ".fields:nth-of-type(7) span.error";
  @FindBy(css = userRequiredCss)
  private WebElement userRequiredText;

  private final String emailCss = "#email_1";
  @FindBy(css = emailCss)
  private WebElement email;

  private final String emailRequiredCss = ".fields:nth-of-type(8) span.error";
  @FindBy(css = emailRequiredCss)
  private WebElement emailRequiredText;

  private final String yourProfilePictureCss = "#profile_pic_10";
  @FindBy(css = yourProfilePictureCss)
  private WebElement yourProfilePicture;

  private final String aboutYourselfCss = "textarea#description";
  @FindBy(css = aboutYourselfCss)
  private WebElement aboutYourself;

  private final String passwordCss = "#password_2";
  @FindBy(css = passwordCss)
  private WebElement password;

  private final String confirmPasswordCss = "#confirm_password_password_2";
  @FindBy(css = confirmPasswordCss)
  private WebElement confirmPassword;

  private final String passworRequiredCss = ".fields:nth-of-type(11) span.error";
  @FindBy(css = passworRequiredCss)
  private WebElement passworRequiredText;

  private final String confirmPasswordRequiredCss = ".fields:nth-of-type(12) span.error";
  @FindBy(css = confirmPasswordRequiredCss)
  private WebElement confirmPasswordRequiredText;

  private final String submitCss = ".piereg_submit_button input";
  @FindBy(css = submitCss)
  private WebElement submit;

  public String getConfirmRegistrationTextOk() {
    return utils.getText(confirmRegistrationOk);
  }

  public String getLoginErrorText() {
    return utils.getText(loginError);
  }

  public String getPasswordStrengthText() {
    return utils.getText(passwordStrength);
  }

  public String getFirstLastNameRequiredText() {
    return utils.getText(firstLastNameRequiredText);
  }

  public String getHobbyRequiredText() {
    return utils.getText(hobbyRequiredText);
  }

  public String getPhoneRequiredText() {
    return utils.getText(phoneRequiredText);
  }

  public String getUserRequiredText() {
    return utils.getText(userRequiredText);
  }

  public String getEmailRequiredText() {
    return utils.getText(emailRequiredText);
  }

  public String getPasswordRequired() {
    return utils.getText(passworRequiredText);
  }

  public String getConfirmPasswordRequiredText() {
    return utils.getText(confirmPasswordRequiredText);
  }

  public void clickSubmit() {
    utils.linkClick(submit);
  }

  public void setFirstName(String text) {
    LOG.info("Set [First Name] (require) field: " + text);
    utils.setText(firstName, text);
  }

  public void setLastName(String text) {
    LOG.info("Set [Last Name] (require) field: " + text);
    utils.setText(lastName, text);
  }

  public void setMaritalStatus(DemoqaRegistrationMaritalStatus maritalStatus) {
    LOG.info("Set [Marital Status] radio: " + maritalStatus);
    for (WebElement element : maritalRadio) {
      if (element.getAttribute("value").equalsIgnoreCase(maritalStatus.getText())) {
        element.click();
      }
    }
  }

  public void setHobby(DemoqaRegistrationHobby hobby) {
    LOG.info("Set [Hobby] checkbox: " + hobby);
    for (WebElement element : hobbyCheckbox) {
      if (element.getAttribute("value").equalsIgnoreCase(hobby.getText())) {
        element.click();
      }
    }
  }

  public void setCountry(DemoqaReistrationCountry country) {
    LOG.info("Set [Country] select: " + country);
    Select countrySelectOption = new Select(countrySelect);
    countrySelectOption.selectByValue(country.getText());
  }

  public void setDayOfBirth(LocalDate dateofBirth) {
    LOG.info("Set [Day Of Birth]: " + dateofBirth.format(DateTimeFormatter.ISO_LOCAL_DATE));

    Select monthSelect = new Select(dateOfBirthMonth);
    monthSelect.selectByValue(Integer.toString(dateofBirth.getMonthValue()));

    Select daySelect = new Select(dateOfBirthDay);
    daySelect.selectByValue(Integer.toString(dateofBirth.getDayOfMonth()));

    Select yearSelect = new Select(dateOfBirthYear);
    yearSelect.selectByValue(Integer.toString(dateofBirth.getYear()));

  }

  public void setPhone(String phoneNumber) {
    LOG.info("Set [Phone] (require) field: " + phoneNumber);
    utils.setText(phone, phoneNumber);
  }

  public void setUserName(String userNameText) {
    LOG.info("Set [Username] (require) field: " + userNameText);
    utils.setText(userName, userNameText);
  }

  public void setEmail(String emailText) {
    LOG.info("Set [email] (require) field: " + emailText);
    utils.setText(email, emailText);
  }

  public void setYourProfilePicture(String file) {
    LOG.info("Set [Your Profile Picture] field: " + file);

  }

  public void setAboutYourself(String text) {
    LOG.info("set [About Yourself] textarea: " + text);
    utils.setText(aboutYourself, text);
  }

  public void setPassword(String text) {
    LOG.info("set [Password] (require) field: " + text);
    utils.setText(password, text);
  }

  public void setConfirmPassword(String text) {
    LOG.info("set [Confirm Password] (require) field: " + text);
    utils.setText(confirmPassword, text);
  }

  public void fillRegistrationForm(DemoqaRegistrationForm dRegForm) {
    LOG.info("Fill registration form.");

    if (dRegForm != null) {

      if (dRegForm.getFirstName() != null) {
        setFirstName(dRegForm.getFirstName());
      }

      if (dRegForm.getLastName() != null) {
        setLastName(dRegForm.getLastName());
      }

      if (dRegForm.getMaritalStatus() != null) {
        setMaritalStatus(dRegForm.getMaritalStatus());
      }

      if (dRegForm.getHobby() != null) {
        setHobby(dRegForm.getHobby());
      }

      if (dRegForm.getCountry() != null) {
        setCountry(dRegForm.getCountry());
      }

      if (dRegForm.getDateofBirth() != null) {
        setDayOfBirth(dRegForm.getDateofBirth());
      }

      if (dRegForm.getPhone() != null) {
        setPhone(dRegForm.getPhone());
      }

      if (dRegForm.getUserName() != null) {
        setUserName(dRegForm.getUserName());
      }

      if (dRegForm.getEmail() != null) {
        setEmail(dRegForm.getEmail());
      }

      if (dRegForm.getYourProfilePicture() != null) {
        setYourProfilePicture(dRegForm.getYourProfilePicture());
      }

      if (dRegForm.getAboutYourself() != null) {
        setAboutYourself(dRegForm.getAboutYourself());
      }

      if (dRegForm.getPassword() != null) {
        setPassword(dRegForm.getPassword());
      }

      if (dRegForm.getConfigmPassword() != null) {
        setConfirmPassword(dRegForm.getConfigmPassword());
      }
    } else {
      //Fail.fail("Object Demoqa Registration Form is not set. Demoqa Registration Form is null");
    }
  }
}

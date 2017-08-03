package demoqaregistration;

import enums.DemoqaEnums.DemoqaRegistrationHobby;
import enums.DemoqaEnums.DemoqaRegistrationMaritalStatus;
import enums.DemoqaEnums.DemoqaReistrationCountry;

import java.time.LocalDate;

public class DemoqaRegistrationForm {


  private String firstName;
  private String lastName;
  private DemoqaRegistrationMaritalStatus maritalStatus;
  private DemoqaRegistrationHobby hobby;
  private DemoqaReistrationCountry country;
  private LocalDate dateofBirth;
  private String phone;
  private String userName;
  private String email;
  private String yourProfilePicture;
  private String aboutYourself;
  private String password;
  private String confirmPassword;

  public DemoqaRegistrationForm(String firstName, String lastName, DemoqaRegistrationMaritalStatus maritalStatus, DemoqaRegistrationHobby hobby, DemoqaReistrationCountry country,
      LocalDate dateofBirth, String phone, String userName, String email, String yourProfilePicture, String aboutYourself, String password, String confirmPassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.maritalStatus = maritalStatus;
    this.hobby = hobby;
    this.country = country;
    this.dateofBirth = dateofBirth;
    this.phone = phone;
    this.userName = userName;
    this.email = email;
    this.yourProfilePicture = yourProfilePicture;
    this.aboutYourself = aboutYourself;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public DemoqaRegistrationMaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(DemoqaRegistrationMaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public DemoqaRegistrationHobby getHobby() {
    return hobby;
  }

  public void setHobby(DemoqaRegistrationHobby hobby) {
    this.hobby = hobby;
  }

  public DemoqaReistrationCountry getCountry() {
    return country;
  }

  public void setCountry(DemoqaReistrationCountry country) {
    this.country = country;
  }

  public LocalDate getDateofBirth() {
    return dateofBirth;
  }

  public void setDateofBirth(LocalDate dateofBirth) {
    this.dateofBirth = dateofBirth;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getYourProfilePicture() {
    return yourProfilePicture;
  }

  public void setYourProfilePicture(String yourProfilePicture) {
    this.yourProfilePicture = yourProfilePicture;
  }

  public String getAboutYourself() {
    return aboutYourself;
  }

  public void setAboutYourself(String aboutYourself) {
    this.aboutYourself = aboutYourself;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfigmPassword() {
    return confirmPassword;
  }

  public void setConfigmPassword(String configmPassword) {
    this.confirmPassword = configmPassword;
  }

}

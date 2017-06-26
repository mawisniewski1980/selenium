package enums;

public class DemoqaEnums {

  public enum DemoqaContactValidationFormText {

    SUCCESS("Your message was sent successfully. Thanks."), ERROR("Validation errors occurred. Please confirm the fields and submit it again.");

    private final String text;

    DemoqaContactValidationFormText(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  public enum DemoqaContactValidationInputText {

    REQUIREFIELD("Please fill the required field."), INVALIDEMAIL("Email address seems invalid.");

    private final String text;

    DemoqaContactValidationInputText(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  public enum DemoqaRegistrationMaritalStatus {
    SINGLE("Single"), MARRIED("Married"), DIVORCED("Divorced");

    private final String text;

    DemoqaRegistrationMaritalStatus(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  public enum DemoqaRegistrationHobby {

    DANCE("Dance"), READING("Reading"), CRICKET("Cricket");

    private final String text;

    DemoqaRegistrationHobby(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

  }

  public enum DemoqaReistrationCountry {

    AFGHANISTAN("Afghanistan"), ALGERIA("Algeria"), ALBANIA("Albania"), AMERICANSAMOA("American Samoa"), ANDORRA("Andorra"), ANGOLA("Angola"), ANTIGUAANDBARBUDA("Antigua and Barbuda"), ARGENTINA(
        "Argentina"), ARMENIA("Armenia"), AUSTRALIA("Australia"), AUSTRIA("Austria"), AZERBAIJAN("Azerbaijan"), BAHAMAS("Bahamas"), BAHRAIN("Bahrain"), BANGLADESH("Bangladesh"), BARBADOS(
            "Barbados"), BELARUS("Belarus"), BELGIUM("Belgium"), BELIZE("Belize"), BENIN("Benin"), BERMUDA("Bermuda"), BHUTAN("Bhutan"), BOLIVIA("Bolivia"), BOSNIAANDHERZEGOVINA(
                "Bosnia and Herzegovina"), BOTSWANA("Botswana"), BRAZIL("Brazil"), BRUNEI("Brunei"), BULGARIA("Bulgaria"), BURKINAFASO("Burkina Faso"), BURUNDI("Burundi"), CAMBODIA(
                    "Cambodia"), CAMEROON("Cameroon"), CANADA("Canada"), CAPEVERDE("Cape Verde"), CENTRALAFRICANREPUBLIC("Central African Republic"), CHAD("Chad"), CHILE("Chile"), CHINA(
                        "China"), COLOMBIA("Colombia"), COMOROS("Comoros"), CONGO("Congo"), COSTARICA("Costa Rica"), COTED_IVOIRE("Côte d'Ivoire"), CROATIA("Croatia"), CUBA("Cuba"), CYPRUS(
                            "Cyprus"), CZECHREPUBLIC("Czech Republic"), DENMARK("Denmark"), DJIBOUTI("Djibouti"), DOMINICA("Dominica"), DOMINICANREPUBLIC("Dominican Republic"), EASTTIMOR(
                                "East Timor"), ECUADOR("Ecuador"), EGYPT("Egypt"), ELSALVADOR("El Salvador"), EQUATORIALGUINEA("Equatorial Guinea"), ERITREA("Eritrea"), ESTONIA("Estonia"), ETHIOPIA(
                                    "Ethiopia"), FIJI("Fiji"), FINLAND("Finland"), FRANCE("France"), GABON("Gabon"), GAMBIA("Gambia"), GEORGIA("Georgia"), GERMANY("Germany"), GHANA("Ghana"), GREECE(
                                        "Greece"), GREENLAND("Greenland"), GRENADA("Grenada"), GUAM("Guam"), GUATEMALA("Guatemala"), GUINEA("Guinea"), GUINEA_BISSAU("Guinea-Bissau"), GUYANA(
                                            "Guyana"), HAITI("Haiti"), HONDURAS("Honduras"), HONGKONG("HongKong"), HUNGARY("Hungary"), ICELAND("Iceland"), INDIA("India"), INDONESIA("Indonesia"), IRAN(
                                                "Iran"), IRAQ("Iraq"), IRELAND("Ireland"), ISRAEL("Israel"), ITALY("Italy"), JAMAICA("Jamaica"), JAPAN("Japan"), JORDAN("Jordan"), KAZAKHSTAN(
                                                    "Kazakhstan"), KENYA("Kenya"), KIRIBATI("Kiribati"), NORTHKOREA("North Korea"), SOUTHKOREA("South Korea"), KUWAIT("Kuwait"), KYRGYZSTAN(
                                                        "Kyrgyzstan"), LAOS("Laos"), LATVIA("Latvia"), LEBANON("Lebanon"), LESOTHO("Lesotho"), LIBERIA("Liberia"), LIBYA("Libya"), LIECHTENSTEIN(
                                                            "Liechtenstein"), LITHUANIA("Lithuania"), LUXEMBOURG("Luxembourg"), MACEDONIA("Macedonia"), MADAGASCAR("Madagascar"), MALAWI(
                                                                "Malawi"), MALAYSIA("Malaysia"), MALDIVES("Maldives"), MALI("Mali"), MALTA("Malta"), MARSHALLISLANDS("Marshall Islands"), MAURITANIA(
                                                                    "Mauritania"), MAURITIUS("Mauritius"), MEXICO("Mexico"), MICRONESIA("Micronesia"), MOLDOVA("Moldova"), MONACO(
                                                                        "Monaco"), MONGOLIA("Mongolia"), MONTENEGRO("Montenegro"), MOROCCO("Morocco"), MOZAMBIQUE("Mozambique"), MYANMAR(
                                                                            "Myanmar"), NAMIBIA("Namibia"), NAURU("Nauru"), NEPAL("Nepal"), NETHERLANDS("Netherlands"), NEWZEALAND(
                                                                                "New Zealand"), NICARAGUA("Nicaragua"), NIGER("Niger"), NIGERIA("Nigeria"), NORWAY("Norway"), NORTHERNMARIANAISLANDS(
                                                                                    "Northern Mariana Islands"), OMAN("Oman"), PAKISTAN("Pakistan"), PALAU("Palau"), PALESTINE("Palestine"), PANAMA(
                                                                                        "Panama"), PAPUANEWGUINEA("Papua New Guinea"), PARAGUAY("Paraguay"), PERU("Peru"), PHILIPPINES(
                                                                                            "Philippines"), POLAND("Poland"), PORTUGAL("Portugal"), PUERTORICO("PuertoRico"), QATAR("Qatar"), ROMANIA(
                                                                                                "Romania"), RUSSIA("Russia"), RWANDA("Rwanda"), SAINTKITTSANDNEVIS("Saint Kitts and Nevis"), SAINTLUCIA(
                                                                                                    "Saint Lucia"), SAINTVINCENTANDTHEGRENADINES("Saint Vincent and the Grenadines"), SAMOA(
                                                                                                        "Samoa"), SANMARINO("San Marino"), SAOTOMEANDPRINCIPE("Sao Tome and Principe"), SAUDIARABIA(
                                                                                                            "Saudi Arabia"), SENEGAL("Senegal"), SERBIAANDMONTENEGRO(
                                                                                                                "Serbia and Montenegro"), SEYCHELLES("Seychelles"), SIERRALEONE(
                                                                                                                    "SierraLeone"), SINGAPORE("Singapore"), SLOVAKIA("Slovakia"), SLOVENIA(
                                                                                                                        "Slovenia"), SOLOMONISLANDS("Solomon Islands"), SOMALIA("Somalia"), SOUTHAFRICA(
                                                                                                                            "South Africa"), SPAIN("Spain"), SRILANKA("SriLanka"), SUDAN(
                                                                                                                                "Sudan"), SUDAN_SOUTH("Sudan,South"), SURINAME("Suriname"), SWAZILAND(
                                                                                                                                    "Swaziland"), SWEDEN("Sweden"), SWITZERLAND("Switzerland"), SYRIA(
                                                                                                                                        "Syria"), TAIWAN("Taiwan"), TAJIKISTAN("Tajikistan"), TANZANIA(
                                                                                                                                            "Tanzania"), THAILAND("Thailand"), TOGO("Togo"), TONGA(
                                                                                                                                                "Tonga"), TRINIDADANDTOBAGO(
                                                                                                                                                    "Trinidad and Tobago"), TUNISIA("Tunisia"), TURKEY(
                                                                                                                                                        "Turkey"), TURKMENISTAN("Turkmenistan"), TUVALU(
                                                                                                                                                            "Tuvalu"), UGANDA("Uganda"), UKRAINE(
                                                                                                                                                                "Ukraine"), UNITEDARABEMIRATES(
                                                                                                                                                                    "United Arab Emirates"), UNITEDKINGDOM(
                                                                                                                                                                        "United Kingdom"), UNITEDSTATES(
                                                                                                                                                                            "United States"), URUGUAY(
                                                                                                                                                                                "Uruguay"), UZBEKISTAN(
                                                                                                                                                                                    "Uzbekistan"), VANUATU(
                                                                                                                                                                                        "Vanuatu"), VATICANCITY(
                                                                                                                                                                                            "Vatican City"), VENEZUELA(
                                                                                                                                                                                                "Venezuela"), VIETNAM(
                                                                                                                                                                                                    "Vietnam"), VIRGINISLANDS_BRITISH(
                                                                                                                                                                                                        "Virgin Islands, British"), VIRGINISLANDS_US(
                                                                                                                                                                                                            "Virgin Islands, U.S."), YEMEN(
                                                                                                                                                                                                                "Yemen"), ZAMBIA(
                                                                                                                                                                                                                    "Zambia"), ZIMBABWE(
                                                                                                                                                                                                                        "Zimbabwe");

    private final String text;

    DemoqaReistrationCountry(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  public enum DemoqaRegistrationValidationInputText {

    REQUIREFIELD("* This field is required"), INVALIDPHONE("* Minimum 10 Digits starting with Country Code"), INVALIDEMAIL("* Invalid email address"), INVALIDPASSWORD(
        "* Fields do not match"), SIZEPASSWORD("* Minimum 8 characters required");

    private final String text;

    DemoqaRegistrationValidationInputText(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  public enum DemoqaRegistrationFormText {

    THANKYOU("Thank you for your registration"), LOGINERROR("Username already exists");

    private final String txt;

    DemoqaRegistrationFormText(String txt) {
      this.txt = txt;
    }

    public String getText() {
      return txt;
    }
  }

  public enum DemoqaRegistrationPasswordStrength {

    VERYWEAK("Very weak"), MISMATCH("Mismatch"), WEAK("Weak"), MEDIUM("Medium"), STRONG("Strong");

    private final String txt;

    DemoqaRegistrationPasswordStrength(String txt) {
      this.txt = txt;
    }

    public String getText() {
      return txt;
    }
  }

  public enum DemoqaAnimationsList {

    SHOW("show", "Show (default)"), SLIDEDOWN("slideDown", "Slide down"), FADEIN("fadeIn", "Fade in"), BLIND("blind", "Blind (UI Effect)"), BOUNCE("bounce", "Bounce (UI Effect)"), CLIP(
        "clip", "Clip (UI Effect)"), DROP("drop", "Drop (UI Effect)"), FOLD("fold", "Fold (UI Effect)"), SLIDE("slide", "Slide (UI Effect)"), NONE("", "None");

    private final String val;
    private final String opt;

    DemoqaAnimationsList(String val, String opt) {
      this.val = val;
      this.opt = opt;
    }

    public String getValue() {
      return val;
    }

    public String getOption() {
      return opt;
    }
  }

  public enum DemoqaFormatDateList {

    DEFAULT("mm/dd/yy", "Default – mm/dd/yy"), ISO("yy-mm-dd", "ISO 8601 – yy-mm-dd"), SHORT("d M, y", "Short – d M, y"), MEDIUM("d MM, y", "Medium – d MM, y"), FULL("DD, d MM, yy",
        "Full – DD, d MM, yy"), WITHDAY("'day' d 'of' MM 'in the year' yy", "With text – ‘day’ d ‘of’ MM ‘in the year’ yy");

    private final String val;
    private final String opt;

    DemoqaFormatDateList(String val, String opt) {
      this.val = val;
      this.opt = opt;
    }

    public String getValue() {
      return val;
    }

    public String getOption() {
      return opt;
    }
  }
}

package demoqa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;

import java.util.Arrays;
import java.util.List;

public class DemoqaAutocomplete extends OPage {

  private static final Logger LOG = LogManager.getLogger("DemoqaAccordion");

  public DemoqaAutocomplete(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityTagsInputCss = "#tagss";
  @FindBy(css = defaultFunctionalityTagsInputCss)
  private WebElement defaultFunctionalityTagsInput;

  private final String defaultFunctionalityTagsUlCss = "ul#ui-id-1";
  @FindBy(css = defaultFunctionalityTagsUlCss)
  private WebElement defaultFunctionalityTagsUl;

  private final String defaultFunctionalityTagsUlLiCss = "ul#ui-id-1 li";
  @FindBy(css = defaultFunctionalityTagsUlLiCss)
  private List<WebElement> defaultFunctionalityTagsUlLi;

  private final String multipleValuesInputCss = "#tagsss";
  @FindBy(css = multipleValuesInputCss)
  private WebElement multipleValuesInput;

  private final String multipleValuesInputUlCss = "ul#ui-id-2";
  @FindBy(css = multipleValuesInputUlCss)
  private WebElement multipleValuesInputUl;

  private final String multipleValuesInputUlLiCss = "ul#ui-id-2 li";
  @FindBy(css = multipleValuesInputUlLiCss)
  private List<WebElement> multipleValuesInputUlLi;

  private final String categoriesSearchInputCss = "#searcha";
  @FindBy(css = categoriesSearchInputCss)
  private WebElement categoriesSearchInput;

  private final String categoriesSearchUlCss = "ul#ui-id-3";
  @FindBy(css = categoriesSearchUlCss)
  private WebElement categoriesSearchUl;

  private final String categoriesSearchUlLiCtegoryCss = " ul#ui-id-3 li.ui-autocomplete-category";
  @FindBy(css = categoriesSearchUlLiCtegoryCss)
  private List<WebElement> categoriesSearchUlLiCtegory;

  private final String categoriesSearchUlLiCss = "ul#ui-id-3 li";
  @FindBy(css = categoriesSearchUlLiCss)
  private List<WebElement> categoriesSearchUlLi;

  public DemoqaAutocomplete setInputAutocompleteDefaultFunctionality(String text) {
    utils.setText(defaultFunctionalityTagsInput, text);
    utils.waits.waitForVisibilityOfElement(defaultFunctionalityTagsUl);
    defaultFunctionalityTagsUlLi.get(utils.getId(defaultFunctionalityTagsUlLi, text)).click();
    return this;
  }

  public String getInputAutocompleteDefaultFunctionalityText() {
    return defaultFunctionalityTagsInput.getAttribute("value");
  }

  public DemoqaAutocomplete setInputAutocompleteMultipleValue(List<String> textList) {
    for(String textFromList : textList) {
      utils.setText(multipleValuesInput, textFromList,false);
      utils.waits.waitForVisibilityOfElement(multipleValuesInputUl);
      multipleValuesInputUlLi.get(utils.getId(multipleValuesInputUlLi, textFromList)).click();
    }
    return this;
  }

  public List<String> getInputAutocompleteMultipleValueText() {
    return Arrays.asList(multipleValuesInput.getAttribute("value").split(", "));
  }

  public DemoqaAutocomplete setInputAutocompleteCategories(String text) {
    utils.setText(categoriesSearchInput, text);
    utils.waits.waitForVisibilityOfElement(categoriesSearchUl);
    categoriesSearchUlLi.get(utils.getId(categoriesSearchUlLi, text)).click();
    return this;
  }

  public String getInputAutocompleteCategoriesText() {
    return categoriesSearchInput.getAttribute("value");
  }
}

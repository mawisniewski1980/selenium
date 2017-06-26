package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaAutocomplete extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaAutocomplete.class.getName());

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

}

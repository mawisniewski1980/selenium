package demoqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.PageObject;

public class DemoqaAccordion extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaAccordion.class.getName());

  public DemoqaAccordion(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityItemsCss = "#accordion h3";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String customizeIconsItemsCss = "#accordion_icons h3";
  @FindBy(css = customizeIconsItemsCss)
  private List<WebElement> customizeIconsItems;

  private final String customizeIconsOnItemsCss = "span";

  private final String customizeIconsButtonCss = "button#toggle";
  @FindBy(css = customizeIconsButtonCss)
  private WebElement customizeIconsButton;

  private final String fillSpaceItemsCss = "#accordion-resizer #accordion_fill h3";
  @FindBy(css = fillSpaceItemsCss)
  private List<WebElement> fillSpaceItems;

  private boolean checkIfSectionIsExpanded(List<WebElement> listOfElements, String title) {
    return listOfElements.get(utils.getId(listOfElements, title)).getAttribute("aria-expanded").equals("true");
  }

  private String getTextFromExpandedDiv(List<WebElement> listOfElements, String title){
    String expandetDivID = listOfElements.get(utils.getId(listOfElements, title)).getAttribute("aria-controls");
    return utils.findNextElementByCssSelector(driver.findElement(By.id(expandetDivID)), By.tagName("p")).getText();
  }

  public DemoqaAccordion clickDefFuncSection(String title) {
    utils.linkClick(defaultFunctionalityItems, title);
    utils.waits.waitTime(1);
    return this;
  }

  public boolean checkIfDefFuncSectionIsExpanded(String title) {
    return checkIfSectionIsExpanded(defaultFunctionalityItems,title);
  }

  public String getDefFuncSectionText(String title) {
    String emptyText = "";
    if(checkIfDefFuncSectionIsExpanded(title)){
      return getTextFromExpandedDiv(defaultFunctionalityItems, title);
    }
    return emptyText;
  }

  public DemoqaAccordion clickCustIcoToggleButton() {
    utils.linkClick(customizeIconsButton);
    return this;
  }

  public boolean checkIfIcoIsVisibleOnCustIcoTab(String title) {
    return utils.findNextElementsByCssSelector(customizeIconsItems.get(utils.getId(customizeIconsItems, title)), By.cssSelector(customizeIconsOnItemsCss)).size() > 0;
  }

  public DemoqaAccordion clickCustIcoSection(String title) {
    utils.linkClick(customizeIconsItems, title);
    utils.waits.waitTime(1);
    return this;
  }

  public boolean checkIfCustIcoSectionIsExpanded(String title) {
    return checkIfSectionIsExpanded(customizeIconsItems,title);
  }

  public String getCustIcoSectionText(String title) {
    String emptyText = "";
    if(checkIfCustIcoSectionIsExpanded(title)){
      return getTextFromExpandedDiv(customizeIconsItems, title);
    }
    return emptyText;
  }

  public DemoqaAccordion clickFillSpaceSection(String title) {
    utils.linkClick(fillSpaceItems, title);
    utils.waits.waitTime(1);
    return this;
  }

  public boolean checkIfFillSpaceSectionIsExpanded(String title) {
    return checkIfSectionIsExpanded(fillSpaceItems,title);
  }

  public String getFillSpaceSectionText(String title) {
    String emptyText = "";
    if(checkIfFillSpaceSectionIsExpanded(title)){
      return getTextFromExpandedDiv(fillSpaceItems, title);
    }
    return emptyText;
  }
}

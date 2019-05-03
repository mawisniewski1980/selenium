package pages;

import abstracts.AbstractPage;
import factories.MyPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class AccordionPage extends AbstractPage {


  public AccordionPage(MyPageFactory pageFactory) {
    super(pageFactory);
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
    return listOfElements.get(getPageFactory().getUtils().getId(listOfElements, title)).getAttribute("aria-expanded").equals("true");
  }

  private String getTextFromExpandedDiv(List<WebElement> listOfElements, String title){
    String expandetDivID = listOfElements.get(getPageFactory().getUtils().getId(listOfElements, title)).getAttribute("aria-controls");
    return getPageFactory().getUtils().findNextElementByCssSelector(getPageFactory().getDriver().findElement(By.id(expandetDivID)), By.tagName("p")).getText();
  }

  public AccordionPage clickDefFuncSection(String title) {
    getPageFactory().getUtils().linkClick(defaultFunctionalityItems, title);
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

  public AccordionPage clickCustIcoToggleButton() {
    getPageFactory().getUtils().linkClick(customizeIconsButton);
    return this;
  }

  public boolean checkIfIcoIsVisibleOnCustIcoTab(String title) {
    return getPageFactory().getUtils().findNextElementsByCssSelector(customizeIconsItems.get(getPageFactory().getUtils().getId(customizeIconsItems, title)), By.cssSelector(customizeIconsOnItemsCss)).size() > 0;
  }

  public AccordionPage clickCustIcoSection(String title) {
    getPageFactory().getUtils().linkClick(customizeIconsItems, title);
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

  public AccordionPage clickFillSpaceSection(String title) {
    getPageFactory().getUtils().linkClick(fillSpaceItems, title);
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

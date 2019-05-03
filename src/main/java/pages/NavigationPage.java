package pages;

import abstracts.AbstractPage;
import factories.MyPageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static selectors.Selectors.ACCORDION;


public class NavigationPage extends AbstractPage {


  public NavigationPage(MyPageFactory pageFactory) {
    super(pageFactory);
  }

  private final String registrationLinkCss = "#menu-item-374";
  @FindBy(css = registrationLinkCss)
  private WebElement registrationLink;

  private final String draggableLinkCss = "#menu-item-140";
  @FindBy(css = draggableLinkCss)
  private WebElement draggableLink;

  private final String droppableLinkCss = "#menu-item-141";
  @FindBy(css = droppableLinkCss)
  private WebElement droppableLink;

  private final String resizableLinkCss = "#menu-item-143";
  @FindBy(css = resizableLinkCss)
  private WebElement resizableLink;

  private final String selectableLinkCss = "#menu-item-142";
  @FindBy(css = selectableLinkCss)
  private WebElement selectableLink;

  private final String sortableLinkCss = "#menu-item-151";
  @FindBy(css = sortableLinkCss)
  private WebElement sortableLink;

  @FindBy(xpath = ACCORDION)
  private WebElement accordionLink;

  private final String autocompleteLinkCss = "#menu-item-145";
  @FindBy(css = autocompleteLinkCss)
  private WebElement autocompleteLink;

  private final String datepickerLinkCss = "#menu-item-146";
  @FindBy(css = datepickerLinkCss)
  private WebElement datepickerLink;

  private final String menuLinkCss = "#menu-item-147";
  @FindBy(css = menuLinkCss)
  private WebElement menuLink;

  private final String sliderLinkCss = "#menu-item-97";
  @FindBy(css = sliderLinkCss)
  private WebElement sliderLink;

  private final String tabsLinkCss = "#menu-item-98";
  @FindBy(css = tabsLinkCss)
  private WebElement tabsLink;

  private final String tooltipLinkCss = "#menu-item-99";
  @FindBy(css = tooltipLinkCss)
  private WebElement tooltipLink;

  private final String framesAndWindowsCss = "#menu-item-148";
  @FindBy(css = framesAndWindowsCss)
  private WebElement framesAndWindows;




///////////////////////////////////////////////


  public AccordionPage accordionLinkClick() {
    getPageFactory().getUtils().linkClick(accordionLink);
    return getPageFactory().getAccordionPage();
  }


}

package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demoqaregistration.DemoqaRegistration;
import menus.OLink;
import pageobject.PageObject;

public class DemoqaPageMenu extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaPageMenu.class.getName());

  public DemoqaPageMenu(WebDriver driver) {
    super(driver);
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

  private final String accordionLinkCss = "#menu-item-144";
  @FindBy(css = accordionLinkCss)
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

  public DemoqaRegistration registrationLinkClick() {
    new OLink(driver, registrationLink).click();
    return new DemoqaRegistration(driver);
  }

  public DemoqaDraggable draggableLinkClick() {
    new OLink(driver, draggableLink).click();
    return new DemoqaDraggable(driver);
  }

  public DemoqaDroppable droppableLinkClick() {
    new OLink(driver, droppableLink).click();
    return new DemoqaDroppable(driver);
  }

  public DemoqaResizable resizableLinkClick() {
    new OLink(driver, resizableLink).click();
    return new DemoqaResizable(driver);
  }

  public DemoqaSelectable selectableLinkClick() {
    new OLink(driver, selectableLink).click();
    return new DemoqaSelectable(driver);
  }

  public DemoqaSortable sortableLinkClick() {
    new OLink(driver, sortableLink).click();
    return new DemoqaSortable(driver);
  }

  public DemoqaAccordion accordionLinkClick() {
    new OLink(driver, accordionLink).click();
    return new DemoqaAccordion(driver);
  }

  public DemoqaAutocomplete autocompleteLinkClick() {
    new OLink(driver, autocompleteLink).click();
    return new DemoqaAutocomplete(driver);
  }

  public DemoqaDatepicker datapickerLinkClick() {
    new OLink(driver, datepickerLink).click();
    return new DemoqaDatepicker(driver);
  }

  public DemoqaPageMenu menuLinkClick() {
    new OLink(driver, menuLink).click();
    return new DemoqaPageMenu(driver);
  }

  public DemoqaSlider sliderLinkClick() {
    new OLink(driver, sliderLink).click();
    return new DemoqaSlider(driver);
  }

  public DemoqaTabs tabsLinkClick() {
    new OLink(driver, tabsLink).click();
    return new DemoqaTabs(driver);
  }

  public DemoqaTooltip tooltipLinkClick() {
    new OLink(driver, tooltipLink).click();
    return new DemoqaTooltip(driver);
  }

  public DemoqaFramesAndWindows framesAndWindowsLinkClick() {
    new OLink(driver, framesAndWindows).click();
    return new DemoqaFramesAndWindows(driver);
  }

}

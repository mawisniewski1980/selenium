package demoqa;

import demoqaregistration.DemoqaRegistration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;




public class DemoqaOPageMenu extends OPage {

  private static final Logger LOG = Logger.getLogger(DemoqaOPageMenu.class.getName());

  public DemoqaOPageMenu(WebDriver driver) {
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
    utils.linkClick(registrationLink);
    return new DemoqaRegistration(driver);
  }

  public DemoqaDraggable draggableLinkClick() {
    utils.linkClick(draggableLink);
    return new DemoqaDraggable(driver);
  }

  public DemoqaDroppable droppableLinkClick() {
    utils.linkClick(droppableLink);
    return new DemoqaDroppable(driver);
  }

  public DemoqaResizable resizableLinkClick() {
    utils.linkClick(resizableLink);
    return new DemoqaResizable(driver);
  }

  public DemoqaSelectable selectableLinkClick() {
    utils.linkClick(selectableLink);
    return new DemoqaSelectable(driver);
  }

  public DemoqaSortable sortableLinkClick() {
    utils.linkClick(sortableLink);
    return new DemoqaSortable(driver);
  }

  public DemoqaAccordion accordionLinkClick() {
    utils.linkClick(accordionLink);
    return new DemoqaAccordion(driver);
  }

  public DemoqaAutocomplete autocompleteLinkClick() {
    utils.linkClick(autocompleteLink);
    return new DemoqaAutocomplete(driver);
  }

  public DemoqaDatepicker datapickerLinkClick() {
    utils.linkClick(datepickerLink);
    return new DemoqaDatepicker(driver);
  }

  public DemoqaOPageMenu menuLinkClick() {
    utils.linkClick(menuLink);
    return new DemoqaOPageMenu(driver);
  }

  public DemoqaSlider sliderLinkClick() {
    utils.linkClick(sliderLink);
    return new DemoqaSlider(driver);
  }

  public DemoqaTabs tabsLinkClick() {
    utils.linkClick(tabsLink);
    return new DemoqaTabs(driver);
  }

  public DemoqaTooltip tooltipLinkClick() {
    utils.linkClick(tooltipLink);
    return new DemoqaTooltip(driver);
  }

  public DemoqaFramesAndWindows framesAndWindowsLinkClick() {
    utils.linkClick(framesAndWindows);
    return new DemoqaFramesAndWindows(driver);
  }

}

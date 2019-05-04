package pages;

import abstracts.AbstractPage;
import factories.SimplePageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static selectors.Selectors.*;


public class NavigationPage extends AbstractPage {

    private static final Logger LOG = LoggerFactory.getLogger(NavigationPage.class);

    public NavigationPage(SimplePageFactory factory) {
        super(factory);
    }

    @FindBy(xpath = HOME)
    private WebElement homeLink;

    @FindBy(xpath = INTERACTIONS)
    private WebElement interactionsLink;

    @FindBy(xpath = WIDGETS)
    private WebElement widgetsLink;

    @FindBy(xpath = SORTABLE)
    private WebElement sortableLink;

    @FindBy(xpath = SELECTABLE)
    private WebElement selectableLink;

    @FindBy(xpath = RESIZABLE)
    private WebElement resizableLink;

    @FindBy(xpath = DROPPABLE)
    private WebElement droppableLink;

    @FindBy(xpath = DRAGGABLE)
    private WebElement draggableLink;

    @FindBy(xpath = TOOLTIP)
    private WebElement tooltipLink;

    @FindBy(xpath = TABS)
    private WebElement tabsLink;

    @FindBy(xpath = SPINNER)
    private WebElement spinnerLink;

    @FindBy(xpath = SLIDER)
    private WebElement sliderLink;

    @FindBy(xpath = SELECT_MENU)
    private WebElement selectmenuLink;

    @FindBy(xpath = PROGRESS_BAR)
    private WebElement progressbarLink;

    @FindBy(xpath = MENU)
    private WebElement menuLink;

    @FindBy(xpath = DIALOG)
    private WebElement dialogLink;

    @FindBy(xpath = DATEPICKER)
    private WebElement datepickerLink;

    @FindBy(xpath = CONTROLGROUP)
    private WebElement controlgroupLink;

    @FindBy(xpath = CHECKBOX_RADIO)
    private WebElement checkboxradioLink;

    @FindBy(xpath = BUTTON)
    private WebElement buttonLink;

    @FindBy(xpath = AUTOCOMPLETE)
    private WebElement autocompleteLink;

    @FindBy(xpath = ACCORDION)
    private WebElement accordionLink;


    public HomePage homePageClick() {
       utils.linkClick(homeLink);
       return factory.homePage();
    }

    public AccordionPage accordionLinkClick() {
        utils.linkClick(accordionLink);
        return factory.accordionPage();
    }



}

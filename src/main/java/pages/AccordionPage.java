package pages;

import abstracts.AbstractPage;
import factories.FactoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static selectors.Selectors.*;


public class AccordionPage extends AbstractPage {

    private static final Logger LOG = LoggerFactory.getLogger(AccordionPage.class);


    public AccordionPage(FactoryPage factory) {
        super(factory);
    }

    @FindBy(css = SECTION_ITEMS)
    private List<WebElement> sectionItems;

    private final String sectionItemsIconSpan = "span";
    @FindBy(css = SECTION_ITEMS_ICON)
    private List<WebElement> sectionItemsIcons;

    private final String sectionItemsIconParagraph = "p";
    @FindBy(css = SECTION_CONTENT)
    private List<WebElement> sectionContents;


    private boolean isTrue(String title, String attribute) {
        return sectionItems.get(utils.getId(sectionItems, title)).getAttribute(attribute).equals("true");
    }

    public boolean isSectionExpanded(String title) {
        return isTrue(title, "aria-expanded");
    }

    public boolean isSectionSelected(String title) {
        return isTrue(title, "aria-selected");
    }

}

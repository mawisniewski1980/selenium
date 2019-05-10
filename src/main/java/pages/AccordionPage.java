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

    public static final String SECTION1_TEXT = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
    public static final String SECTION2_TEXT = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
    public static final String SECTION3_TEXT = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.";
    public static final String SECTION4_TEXT = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.";

    public AccordionPage(FactoryPage factory) {
        super(factory);
    }

    @FindBy(css = SECTION_ITEMS)
    private List<WebElement> sectionItems;

    private final String sectionItemsIconSpan = "span";
    @FindBy(css = SECTION_ITEMS_ICON)
    private List<WebElement> sectionItemsIcons;

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

    public AccordionPage click(String title) {
        utils.linkClick(sectionItems, title);
        return this;
    }

    public String getText(String title) {
        return utils.getTextFromWebElementList(sectionContents).get(utils.getId(sectionItems, title));
    }
}

package pages;

import abstracts.AbstractPage;
import factories.SimplePageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static selectors.Selectors.ENTRY_TITLE;

public class BasePage extends AbstractPage {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public BasePage(SimplePageFactory factory) {
        super(factory);
    }

    @FindBy(css = ENTRY_TITLE)
    private WebElement entryTitle;

    public String getEntryTitle() {
        return utils.getText(entryTitle);
    }

    public String getTitle() {
        LOG.info("Title: {}", factory.getDriver().getTitle());
        return factory.getDriver().getTitle();
    }
}

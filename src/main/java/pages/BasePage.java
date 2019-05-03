package pages;

import abstracts.AbstractPage;
import factories.SimplePageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static selectors.Selectors.ENTRY_TITLE;

public class BasePage extends AbstractPage {

    public BasePage(SimplePageFactory pageFactory) {
        super(pageFactory);
    }

    @FindBy(css = ENTRY_TITLE)
    private WebElement entryTitle;

    public String getEntryTitle() {
        return pageFactory.utils().getText(entryTitle);
    }
}

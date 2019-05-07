package factories;

import abstracts.AbstractPage;
import enums.Pages;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AccordionPage;
import pages.BasePage;
import pages.HomePage;
import pages.NavigationPage;

public enum SimplePageFactory {

    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(SimplePageFactory.class);

    private WebDriver driver;

    SimplePageFactory() {
    }

    public SimplePageFactory setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationPage navigation() {
        return new NavigationPage(this);
    }

    public BasePage basePage() {
        return new BasePage(this);
    }

    public HomePage homePage() {
        return new HomePage(this);
    }

    public AccordionPage accordionPage() {
        return new AccordionPage(this);
    }

    public AbstractPage createPage(Pages page) {
        switch(page) {

            case NAVIGATION:
                return new NavigationPage(this);
            case BASE:
                return new BasePage(this);
            case HOME:
                return new HomePage(this);
            case ACCORDION:
                return new AccordionPage(this);
                default:
                    return null;
        }
    }
}

package factories;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AccordionPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utils;

public final class FactoryPage {

    private static final Logger LOG = LoggerFactory.getLogger(FactoryPage.class);

    private WebDriver driver;

    public FactoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Utils getUtils() {
        return new Utils(driver);
    }

    public NavigationPage getNavigationPage() {
        return new NavigationPage(this);
    }

    public HomePage getHomePage() {
        return new HomePage(this);
    }

    public AccordionPage getAccordionPage() {
        return new AccordionPage(this);
    }

}

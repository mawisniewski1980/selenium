package factories;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import pages.AccordionPage;
import pages.BasePage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utils;

public class SimplePageFactory {

    private WebDriver driver;
    private Utils utils;

    public SimplePageFactory(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Utils utils() {
        return utils;
    }

    public BasePage basePage() {
        return new BasePage(this);
    }

    public NavigationPage navigation() {
        return new NavigationPage(this);
    }

    public HomePage getHomePage() {
        return new HomePage(this);
    }

    public AccordionPage getAccordionPage() {
        return new AccordionPage(this);
    }


}

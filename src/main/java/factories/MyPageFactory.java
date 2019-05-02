package factories;

import org.openqa.selenium.WebDriver;
import pages.AccordionPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utils;

public class MyPageFactory {

    private WebDriver driver;

    private NavigationPage navigationPage;
    private HomePage homePage;
    private AccordionPage accordionPage;

    private Utils utils;

    public MyPageFactory(WebDriver driver) {
        this.driver = driver;
        navigationPage = new NavigationPage(this, driver);
        homePage = new HomePage(this, driver);
        accordionPage = new AccordionPage(this, driver);
        utils = new Utils(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Utils getUtils() {
        return utils;
    }

    public NavigationPage getNavigationPage() {
        return navigationPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public AccordionPage getAccordionPage() {
        return accordionPage;
    }


}

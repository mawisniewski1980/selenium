package testobject;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilsobjects.OUtils;

import java.time.Duration;

public class OTestRules extends TestWatcher {

    private static final Logger LOG = LoggerFactory.getLogger(OTestRules.class.getSimpleName());

    private WebDriver driver;
    private OUtils utils;

    public OTestRules(WebDriver driver) {
        this.driver = driver;
        utils = new OUtils(driver);
    }

    @Override
    protected void starting(Description description) {
        super.starting(description);
        LOG.info("#####################################  START " + utils.startDateTime() + " " + utils.getInfoAboutSystem() + " #####################################");
        LOG.info("#####################################  " + description.getClassName() + " ### " + description.getMethodName() + " #####################################");
    }

    @Override
    protected void failed(Throwable t, Description description) {
        super.failed(t,description);
        LOG.info("###### Failed test in class '" + description.getClassName() + "' method name '" + description.getMethodName() + "' ######");
        new OUtils(driver).takeScreenShoot(description.getClassName(), description.getMethodName());
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
        driver.manage().deleteAllCookies();
        driver.quit();
        LOG.info("#####################################  STOP " + utils.endDateTime() + " " + utils.getInfoAboutSystem() + " #####################################");
        LOG.info("#####################################  " + description.getClassName() + " ### " + description.getMethodName() + " #####################################");
    }
}

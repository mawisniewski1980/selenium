package testobject;

import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import utilsobjects.OLogs;

import java.util.concurrent.TimeUnit;




public class OTestRules extends TestWatcher {

    private static final Logger LOG = Logger.getLogger(OTestRules.class);

    private WebDriver driver;
    private long startTime = OLogs.getTimeNow();

    public OTestRules(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void starting(Description description) {
        LOG.info("#####################################  START " + OLogs.getDateTimeNowFormated() + " ########################################################");
    }

    @Override
    protected void failed(Throwable t, Description description) {
        LOG.info("###### FAILED " + description.getClassName() + " -> " + description.getMethodName() + " ######");
        OLogs.takeScreenFile(driver, description.getClassName(), description.getMethodName(), false);
        OLogs.takeLogFile(description.getClassName(), description.getMethodName(), false);
    }

    @Override
    protected void finished(Description description) {
        driver.manage().deleteAllCookies();
        driver.quit();
        LOG.info("##################################### STOP " + OLogs.getDateTimeNowFormated() + " in " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) + " seconds " +
                "############################################");
    }
}

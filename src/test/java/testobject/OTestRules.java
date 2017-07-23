package testobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import utilsobjects.OLogs;

import java.util.concurrent.TimeUnit;


public class OTestRules extends TestWatcher {

    private static final Logger LOG = LogManager.getLogger("OTestRules");

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
        LOG.error("########################################### FAILED ###########################################");
        LOG.error("########### CLASS " + description.getClassName() + " ###########");
        LOG.error("########### METHOD " + description.getMethodName()+ " ###########");
        LOG.error("########### ERROR " + t.getMessage() + " ###########");
        LOG.error("########### ERROR2 " + t + " ###########");
        for(int i = 0; i < t.getStackTrace().length; i++) {
            LOG.error("-> STACKTRACE " + t.getStackTrace()[i] + " <-");
        }
    }

    @Override
    protected void succeeded(Description description) {
        LOG.info("################################################ SUCCEEDED #################################################");
        LOG.info("######################### CLASS " + description.getClassName() + " ########################");
        LOG.info("######################### METHOD " + description.getMethodName()+ " #######################");
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        LOG.info("########################################### SKIPPED ###########################################");
        LOG.info("######################### CLASS " + description.getClassName() + " ########################");
        LOG.info("######################### METHOD " + description.getMethodName()+ " #######################");
        LOG.error("######################## ERROR " + e.getMessage() + " ####################################");
        for(int i = 0; i < e.getStackTrace().length; i++) {
            LOG.error("-> STACKTRACE " + e.getStackTrace()[i] + " <-");
        }
    }

    @Override
    protected void finished(Description description) {
        driver.manage().deleteAllCookies();
        driver.quit();
        LOG.info("####################################### STOP " + OLogs.getDateTimeNowFormated() + " in " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) + " seconds " +
                "##############################################");
    }
}

package testobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import utilsobjects.OLogs;

import java.util.concurrent.TimeUnit;


public class OTestRules extends TestWatcher {

    private static final Logger LOG = LogManager.getLogger("OTestRules");

    private OLogs logs;

    private long startTime = System.currentTimeMillis();

    public OTestRules(OLogs oLogs) {
        this.logs = oLogs;
    }

    @Override
    protected void starting(Description description) {
        LOG.info("###  START " + logs.getDateTimeNowFormated_yyyyMMdd_HHmmss() + " ###");
    }

    @Override
    protected void failed(Throwable t, Description description) {
        LOG.error("### FAILED ###");
        LOG.error("### CLASS " + description.getClassName() + " ###");
        LOG.error("### METHOD " + description.getMethodName()+ " ###");
        LOG.error("### ERROR " + t.getMessage() + " ###");
        for(int i = 0; i < t.getStackTrace().length; i++) {
            LOG.error("### STACKTRACE " + t.getStackTrace()[i] + " ###");
        }
        logs.setClassName(description.getClassName());
        logs.setMethodName(description.getMethodName());
        logs.takeScreenFile(false);
    }

    @Override
    protected void succeeded(Description description) {
        LOG.info("### SUCCEEDED ###");
        LOG.info("### CLASS " + description.getClassName() + " ###");
        LOG.info("### METHOD " + description.getMethodName()+ " ###");
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        LOG.info("### SKIPPED ###");
        LOG.info("### CLASS " + description.getClassName() + " ###");
        LOG.info("### METHOD " + description.getMethodName()+ " ###");
        LOG.error("### ERROR " + e.getMessage() + " ###");
        for(int i = 0; i < e.getStackTrace().length; i++) {
            LOG.error("### STACKTRACE " + e.getStackTrace()[i] + " ###");
        }
    }

    @Override
    protected void finished(Description description) {
        logs.getDriver().manage().deleteAllCookies();
        logs.getDriver().quit();
        LOG.info("### STOP " + logs.getDateTimeNowFormated_yyyyMMdd_HHmmss() + " in " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) + " seconds " +
                " ###");
    }
}

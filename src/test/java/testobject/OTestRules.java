package testobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import utilsobjects.OUtils;

import java.util.concurrent.TimeUnit;


public class OTestRules extends TestWatcher {

    private static final Logger LOG = LogManager.getLogger("OTestRules");

    private OUtils utils;

    private long startTime = System.currentTimeMillis();

    public OTestRules(OUtils utils) {
        this.utils = utils;
    }

    @Override
    protected void starting(Description description) {
        LOG.info("###########################################################################################");
        LOG.info("#########  START " + utils.getLogs().getDateTimeNowFormated_yyyyMMdd_HHmmss());
        LOG.info("###########################################################################################");
        LOG.info("#########  SYSTEM INFO " + utils.getInfoAboutSystem());
        LOG.info("#########  CLASS " + description.getClassName());
        LOG.info("#########  METHOD " + description.getMethodName());
        LOG.info("###########################################################################################");
        LOG.info("###########################################################################################");
    }

    @Override
    protected void failed(Throwable t, Description description) {
        LOG.info("###########################################################################################");
        LOG.info("###########################################################################################");
        LOG.error("#########  #########  FAILED  #########  #########");
        LOG.info("###########################################################################################");
        LOG.error("#########  CLASS " + description.getClassName());
        LOG.error("#########  METHOD " + description.getMethodName());
        LOG.error("#########  ERROR " + t.getMessage() + " ###");
        for(int i = 0; i < t.getStackTrace().length; i++) {
            LOG.error("#########  STACKTRACE " + t.getStackTrace()[i]);
        }
        LOG.error("#########  SCREEN SHOT FILE");
        utils.getLogs().setClassName(description.getClassName());
        utils.getLogs().setMethodName(description.getMethodName());
        utils.getLogs().takeScreenFile(false);
    }

    @Override
    protected void succeeded(Description description) {
        LOG.info("###########################################################################################");
        LOG.info("###########################################################################################");
        LOG.info("#########  #########  SUCCEEDED  #########  #########");
        LOG.info("###########################################################################################");
        LOG.info("#########  CLASS " + description.getClassName());
        LOG.info("#########  METHOD " + description.getMethodName());
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        LOG.info("###########################################################################################");
        LOG.info("###########################################################################################");
        LOG.info("#########  #########  SKIPPED  #########  #########");
        LOG.info("###########################################################################################");
        LOG.info("#########  CLASS " + description.getClassName());
        LOG.info("#########  METHOD " + description.getMethodName());
        LOG.info("#########  ERROR " + e.getMessage());
        for(int i = 0; i < e.getStackTrace().length; i++) {
            LOG.info("######### STACKTRACE " + e.getStackTrace()[i]);
        }
    }

    @Override
    protected void finished(Description description) {
        utils.getDriver().manage().deleteAllCookies();
        utils.getDriver().quit();
        LOG.info("###########################################################################################");
        LOG.info("#########  STOP " + utils.getLogs().getDateTimeNowFormated_yyyyMMdd_HHmmss() + " in " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) + " seconds");
        LOG.info("###########################################################################################");
    }
}

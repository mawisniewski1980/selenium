package utilsobjects;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class OLogs {

   private static final Logger LOG = LogManager.getLogger("OLogs");

   private WebDriver driver;
   private String className;
   private String methodName;

    public OLogs(WebDriver driver) {
        this.driver = driver;
    }

    public OLogs(WebDriver driver, String className) {
        this(driver);
        this.className = className;
    }

    public OLogs(WebDriver driver, String className, String methodName) {
        this(driver, className);
        this.methodName = methodName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDateNow_yyyyMMdd() {
      return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String getDateTimeNow_yyyyMMdd_HHmmss() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    public String getDateTimeNowFormated_yyyyMMdd_HHmmss() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getBasePath() {
        return new OProperties().getProperty("basepathlogs");
    }

    public String getBasePathFileName() {
        return getBasePath() + "\\" + getFileName();
    }

    public String getFileName() {
        return getDateTimeNow_yyyyMMdd_HHmmss() + "_" + getMethodName();
    }

    public String getPathAndFileName() {
        return getClassName() + "\\" + getMethodName() + "\\" + getFileName();
    }

    public void takeScreenFile() {
        takeScreenFile(true);
    }

    public void takeScreenFile(boolean pass) {

    File destFile = null;

    try {
      File screenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      destFile = new File(getBasePathFileName() + ".png");
      FileUtils.copyFile(screenShoot, destFile);
    } catch (IOException e) {
      LOG.error("Cannot copy file");
     }
        if(!pass) {
            try {
                FileUtils.moveFile(destFile, new File(getBasePath() + "\\FAIL\\" + getPathAndFileName() + ".png"));
            } catch (IOException e) {
                LOG.error("Cannot copy file");
            }
        }


    }



}

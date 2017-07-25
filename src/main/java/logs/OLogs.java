package logs;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilsobjects.OProperties;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OLogs {

   private static final Logger LOG = LogManager.getLogger("OLogs");

   private WebDriver driver;
   private String className;
   private String methodName;

    public OLogs(WebDriver driver) {
        this.driver = driver;
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
      return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
        return getDateNow_yyyyMMdd() + "_" + getMethodName();
    }

    public String getPathAndFileName() {
        return getClassName() + "\\" + getMethodName() + "\\" + getFileName();
    }

    public String getFailPath() {
       return getBasePath() + "\\" + getDateNow_yyyyMMdd()+ "_FAIL\\" + getPathAndFileName();
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
                FileUtils.moveFile(destFile, new File(getFailPath() + ".png"));
            } catch (IOException e) {
                LOG.error("Cannot move file");
            }
        }
    }

    public void takeLogFile(boolean pass) {


    }

}

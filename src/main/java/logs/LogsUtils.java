package logs;

import date.DateFormatterUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import utilsobjects.Properties;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LogsUtils {

    private WebDriver driver;
    private String className;
    private String methodName;
    private String basePath = Properties.getBasePath();


    public LogsUtils(WebDriver driver) {
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

    public String getFileName() {
        return DateFormatterUtils.getDateNow_yyyyMMdd() + "_" + getMethodName();
    }

    public String getBasePathFileName() {
        return basePath + "\\" + getFileName();
    }

    public String getPathAndFileName() {
        return getClassName() + "\\" + getMethodName() + "\\" + getFileName();
    }

    public String getFailPath() {
        return basePath + "\\" + DateFormatterUtils.getDateNow_yyyyMMdd()+ "_FAIL\\" + getPathAndFileName();
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
            //logger.error("Cannot copy file");
        }
        if(!pass) {
            try {
                FileUtils.moveFile(destFile, new File(getFailPath() + ".png"));
            } catch (IOException e) {
                //logger.error("Cannot move file");
            }
        }
    }

    public void takeLogFile(boolean pass) {


    }

    public void takeWebriverLogs() {
        List<LogEntry> entries = driver.manage().logs().get(LogType.BROWSER).getAll();
        //logger.info(entries.size() + " " + LogType.BROWSER + " log entries found");
        for (LogEntry entry : entries) {
            //logger.info("Level ");
        }
    }

}

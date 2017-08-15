package logs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import utilsobjects.Properties;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogsUtils {

    private WebDriver driver;
    private String className;
    private String methodName;

    public LogsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public LogsUtils(WebDriver driver, String className, String methodName) {
        this(driver);
        this.className = className;
        this.methodName = methodName;
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

    public String getInfoAboutSystem() {
        return "[Java " + System.getProperty("java.version") + "][" + System.getProperty("os.name") + ", " + System.getProperty("os.version") + ", " + System.getProperty("os.arch") + "]";
    }

    public String getDateNow_yyyyMMdd() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDateTimeNowFormated_yyyyMMdd_HHmmss() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getBasePath() {
        return new Properties().getProperty("basepathlogs");
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
            ////LOG.error("Cannot copy file");
        }
        if(!pass) {
            try {
                FileUtils.moveFile(destFile, new File(getFailPath() + ".png"));
            } catch (IOException e) {
                ////LOG.error("Cannot move file");
            }
        }
    }

    public void takeLogFile(boolean pass) {


    }

    public void takeWebriverLogs() {
        List<LogEntry> entries = driver.manage().logs().get(LogType.BROWSER).getAll();
        ////LOG.info(entries.size() + " " + LogType.BROWSER + " log entries found");
        for (LogEntry entry : entries) {
            ////LOG.info("Level ");
        }
    }

}
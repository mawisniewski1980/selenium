package utilsobjects;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OLogs {

  private static final Logger LOG = Logger.getLogger(OLogs.class);

   private static SimpleLayout layout = new SimpleLayout();
   private static FileAppender appender;

   public static long getTimeNow() {
      return System.currentTimeMillis();
  }

    public static String getDateNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static String getDateTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    public static String getDateTimeNowFormated() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String getFileName(String methodName) {
        return getDateTimeNow() + "_" + methodName;
    }

    public static String getBasePath() {
        return new OProperties().getProperty("basepathlogs");
    }

    public static String getFileNameWithPath(String className, String methodName, boolean pass) {
        if(pass) return getBasePath() + (getDateNow() + "_passed\\") + className + "\\" + methodName + "\\"+ getFileName(methodName);
        return getBasePath() + (getDateNow() + "_fail\\") + className + "\\" + methodName + "\\"+ getFileName(methodName);
    }

    public static void takeScreenFile(WebDriver driver, String className, String methodName, boolean pass) {

        String pathAndFile = OLogs.getFileNameWithPath(className, methodName, pass) + ".png";
        try {
            File screenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShoot, new File(pathAndFile));
        } catch (IOException e) {
            LOG.info("Cannot copy file");
            e.printStackTrace();
        }
    }

    public static void takeLogFile(String className, String methodName, boolean pass) {

        String pathAndFile = getFileNameWithPath(className, methodName, pass) + ".log";
        try {
            appender = new FileAppender(layout, pathAndFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

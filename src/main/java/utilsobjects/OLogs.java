package utilsobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OLogs {

    private static final Logger LOG = LogManager.getLogger("OLogs");

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

    public String getBasePath() {
        return new OProperties().getProperty("basepathlogs");
    }

    public static String getCurrentMethodName() {
       return new Object(){}.getClass().getEnclosingMethod().getName();
    }

    public String getCurrentClassName() {
        //return new Object(){}.getClass().getEnclosingClass().getName();
        return this.getClass().getName();
    }

    public String getFileName() {
        return getDateTimeNow() + "_" + getCurrentMethodName();
    }

    public String getPathAndFileName() {
        return getBasePath() + "\\" + LOG.getClass().getName() + "\\" + getFileName();
    }





}

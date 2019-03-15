package date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterUtils {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static LocalDate date;

    public static String getFormattedDate_MMMMd_uuuu(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM d, uuuu", Locale.ENGLISH));
    }

    public static String getFormattedDate_MMMMd_uuuu(LocalDate date, Locale locale) {
        return date.format(DateTimeFormatter.ofPattern("MMMM d, uuuu", locale));
    }

    public static String getFormattedDate_mm_dd_yy_dafault(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/u", Locale.ENGLISH));
    }

    public static String getFormattedDate_yy_mm_dd_iso(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("u-MM-dd", Locale.ENGLISH));
    }

    public static String getFormattedDate_dM_y_short(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd MMM, uu", Locale.ENGLISH));
    }

    public static String getFormattedDate_dMM_y_medium(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd MMMM, uu", Locale.ENGLISH));
    }

    public static String getFormattedDate_DD_dMM_yy_full(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, uuuu", Locale.ENGLISH));
    }

    public static String getFormattedDate_day_d_of_MM_inTheYear_yy_withDay(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("'day 'dd' of 'MMMM' in the year 'uuuu", Locale.ENGLISH));
    }

    public static String getDateNow_yyyyMMdd() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String getDateTimeNowFormated_yyyyMMdd_HHmmss() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

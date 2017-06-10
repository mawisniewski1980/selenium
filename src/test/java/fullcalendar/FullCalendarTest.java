package fullcalendar;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import enums.PageUrls.PageUrl;
import fullcalendar.FullCalendarPage.TIMEHOURS;
import fullcalendar.FullCalendarPage.VIEW;
import testobject.TestObject;

public class FullCalendarTest extends TestObject {

  // private static final Logger LOG = LoggerFactory.getLogger(FullCalendarTest.class.getName());

  private FullCalendarPage fp;

  @Before
  public void setTest() {
    setUrl(PageUrl.FULLCALENDAR);
    fp = new FullCalendarPage(driver);
  }

  @Test
  public void getTitle() {
    assertEquals("FullCalendar - JavaScript Event Calendar", driver.getTitle());
  }

  @Test
  public void clickOnAllButtons() {
    fp.listButtonClick();
    utils.waitTime(2);
    fp.monthButtonClick();
    utils.waitTime(2);
    fp.weekButtonClick();
    utils.waitTime(2);
    fp.dayButtonClick();
    utils.waitTime(2);
    fp.buttonArrayClick(1);
  }

  @Test
  public void checkIfDateIsOnCalendar() {
    fp.monthButtonClick();
    fp.isDateOnCalendar(LocalDate.now());
    fp.todayButtonClick();
    fp.isDateOnCalendar(LocalDate.now());

    fp.weekButtonClick();
    fp.isDateOnCalendar(LocalDate.now());

    fp.dayButtonClick();
    fp.isDateOnCalendar(LocalDate.now());

    fp.listButtonClick();
    // fp.isDateOnCalendar(LocalDate.now());
  }

  @Test
  public void setDateTest() {

    LocalDate checkDate = LocalDate.now().minusDays(42);

    fp.monthButtonClick();
    fp.setDate(checkDate);
    System.out.println("##################################################");
    utils.waitTime(3);

    fp.weekButtonClick();
    fp.setDate(checkDate);
    System.out.println("##################################################");
    utils.waitTime(3);

    fp.dayButtonClick();
    fp.setDate(checkDate);
    System.out.println("##################################################");
    utils.waitTime(3);

  }

  @Test
  public void getEventsSizeFromCalendarInMonth() {
    fp.monthButtonClick();

    for (int i = 1; i <= 12; i++) {
      System.out.println(fp.getHeaderOfCalendar().getText().toString());
      System.out.println(fp.getEventsSize());
      fp.nextButtonClick();
    }
  }

  @Test
  public void moveWebElement() {
    LocalDate date = LocalDate.of(2016, Month.SEPTEMBER, 17);
    fp.moveWebElement(VIEW.WEEK, date, TIMEHOURS._100000, "Lunch");
    utils.waitTime(5);
  }

}

package fullcalendar;

import enums.CalendarEnums.TIMEHOURS;
import enums.CalendarEnums.VIEW;
import enums.PageUrls.PageUrl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testobject.TestObject;

import java.time.LocalDate;
import java.time.Month;

import static org.testng.Assert.*;


public class FullCalendarTest extends TestObject {


  private FullCalendarPageObject fp;

  @BeforeTest
  public void setTest() {
    setUrl(PageUrl.FULLCALENDAR);
    fp = new FullCalendarPageObject(driver);
  }

  @Test
  public void getTitle() {
    assertEquals("FullCalendar - JavaScript Event Calendar", driver.getTitle());
  }

  @Test
  public void clickOnListButton() {
    fp.listButtonClick();
    assertTrue(fp.checkIfDayButtonIsActive());
  }

  @Test
  public void clickOnMonthButton() {
    fp.monthButtonClick();
    assertTrue(fp.checkIfDayButtonIsActive());
  }

  @Test
  public void clickOnWeekButton() {
    fp.weekButtonClick();
    assertTrue(fp.checkIfDayButtonIsActive());
  }

  @Test
  public void clickOnDayButton() {
    fp.dayButtonClick();
    assertTrue(fp.checkIfDayButtonIsActive());
  }

  @Test
  public void clickOnAllButtons() {
    fp.listButtonClick();
    fp.monthButtonClick();
    fp.weekButtonClick();
    fp.dayButtonClick();
    assertTrue(fp.checkIfDayButtonIsActive());
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarMonthView() {
    LocalDate checkedDated = LocalDate.now();
    logger.info("Check date " + checkedDated + " on month view");
    fp.monthButtonClick();
    assertFalse(fp.isDateOnCalendar(checkedDated));
  }

  @Test
  public void checkIfDateNowIsOnCalendarToday() {
    LocalDate checkedDated = LocalDate.now();
    logger.info("Check date " + checkedDated + " after click [Today] button on today view");
    fp.todayButtonClick();
    assertTrue(fp.isDateOnCalendar(checkedDated));
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarWeekView() {
    LocalDate checkedDated = LocalDate.now();
    logger.info("Check date " + checkedDated + " on week view");
    fp.weekButtonClick();
    assertFalse(fp.isDateOnCalendar(checkedDated));
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarDayView() {
    LocalDate checkedDated = LocalDate.now();
    logger.info("Check date " + checkedDated + " on day view");
    fp.dayButtonClick();
    assertFalse(fp.isDateOnCalendar(checkedDated));
  }

  @Test
  public void setDateMonthView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.minusDays(42);

    fp.monthButtonClick();
    fp.setDate(checkDate);
    assertEquals(dateNow.minusDays(42), checkDate);
  }

  @Test
  public void setDateWeekView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.plusDays(42);

    fp.weekButtonClick();
    fp.setDate(checkDate);
    assertEquals(dateNow.plusDays(42), checkDate);
  }

  @Test
  public void setDateDayView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.plusDays(15);

    fp.weekButtonClick();
    fp.setDate(checkDate);
    assertEquals(dateNow.plusDays(15), checkDate);
  }

  // TODO
  @Test
  public void moveWebElement() {
    LocalDate date = LocalDate.of(2016, Month.SEPTEMBER, 17);
    fp.moveWebElement(VIEW.WEEK, date, TIMEHOURS._100000, "Lunch");
  }

}

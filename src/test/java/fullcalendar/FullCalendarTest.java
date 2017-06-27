package fullcalendar;

import static org.fest.assertions.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.CalendarEnums.TIMEHOURS;
import enums.CalendarEnums.VIEW;
import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class FullCalendarTest extends TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(FullCalendarTest.class.getName());

  private FullCalendarPage fp;

  @Before
  public void setTest() {
    setUrl(PageUrl.FULLCALENDAR);
    fp = new FullCalendarPage(driver);
  }

  @Test
  public void getTitle() {
    assertThat(driver.getTitle()).isEqualTo("FullCalendar - JavaScript Event Calendar");
  }

  @Test
  public void clickOnListButton() {
    fp.listButtonClick();
    assertThat(fp.checkIfDayButtonIsActive()).isTrue();
  }

  @Test
  public void clickOnMonthButton() {
    fp.monthButtonClick();
    assertThat(fp.checkIfDayButtonIsActive()).isTrue();
  }

  @Test
  public void clickOnWeekButton() {
    fp.weekButtonClick();
    assertThat(fp.checkIfDayButtonIsActive()).isTrue();
  }

  @Test
  public void clickOnDayButton() {
    fp.dayButtonClick();
    assertThat(fp.checkIfDayButtonIsActive()).isTrue();
  }

  @Test
  public void clickOnAllButtons() {
    fp.listButtonClick();
    fp.monthButtonClick();
    fp.weekButtonClick();
    fp.dayButtonClick();
    assertThat(fp.checkIfDayButtonIsActive()).isTrue();
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarMonthView() {
    LocalDate checkedDated = LocalDate.now();
    LOG.info("Check date " + checkedDated + " on month view");
    fp.monthButtonClick();
    assertThat(fp.isDateOnCalendar(checkedDated)).isFalse();
  }

  @Test
  public void checkIfDateNowIsOnCalendarToday() {
    LocalDate checkedDated = LocalDate.now();
    LOG.info("Check date " + checkedDated + " after click [Today] button on today view");
    fp.todayButtonClick();
    assertThat(fp.isDateOnCalendar(checkedDated)).isTrue();
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarWeekView() {
    LocalDate checkedDated = LocalDate.now();
    LOG.info("Check date " + checkedDated + " on week view");
    fp.weekButtonClick();
    assertThat(fp.isDateOnCalendar(checkedDated)).isFalse();
  }

  @Test
  public void checkIfDateNowIsNotOnCalendarDayView() {
    LocalDate checkedDated = LocalDate.now();
    LOG.info("Check date " + checkedDated + " on day view");
    fp.dayButtonClick();
    assertThat(fp.isDateOnCalendar(checkedDated)).isFalse();
  }

  @Test
  public void setDateMonthView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.minusDays(42);

    fp.monthButtonClick();
    fp.setDate(checkDate);
    assertThat(checkDate).isEqualTo(dateNow.minusDays(42));
  }

  @Test
  public void setDateWeekView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.plusDays(42);

    fp.weekButtonClick();
    fp.setDate(checkDate);
    assertThat(checkDate).isEqualTo(dateNow.plusDays(42));
  }

  @Test
  public void setDateDayView() {

    LocalDate dateNow = LocalDate.now();
    LocalDate checkDate = dateNow.plusDays(15);

    fp.weekButtonClick();
    fp.setDate(checkDate);
    assertThat(checkDate).isEqualTo(dateNow.plusDays(15));
  }

  // TODO
  @Test
  public void moveWebElement() {
    LocalDate date = LocalDate.of(2016, Month.SEPTEMBER, 17);
    fp.moveWebElement(VIEW.WEEK, date, TIMEHOURS._100000, "Lunch");
  }

}

package fullcalendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import menus.OButton;
import pageobject.PageObject;

public class FullCalendarPage extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(FullCalendarPage.class.getName());

  public FullCalendarPage(WebDriver driver) {
    super(driver);
  }

  public enum TIMEHOURS {
    _000000("00:00:00", 1), _003000("00:30:00", 2), _010000("01:00:00", 3), _013000("01:30:00", 4), _020000("02:00:00", 5), _023000("02:30:00", 6), _030000("03:00:00", 7), _033000("03:30:00",
        8), _040000("04:00:00", 9), _043000("04:30:00", 10), _050000("05:00:00", 11), _053000("05:30:00", 12), _060000("06:00:00", 13), _063000("06:30:00", 14), _070000("07:00:00",
            15), _073000("07:30:00", 16), _080000("08:00:00", 17), _083000("08:30:00", 18), _090000("09:00:00", 19), _093000("09:30:00", 20), _100000("10:00:00", 21), _103000("10:30:00",
                22), _110000("11:00:00", 23), _113000("11:30:00", 24), _120000("12:00:00", 25), _123000("12:30:00", 26), _130000("13:00:00", 27), _133000("13:30:00", 28), _140000("14:00:00",
                    29), _143000("14:30:00", 30), _150000("15:00:00", 31), _153000("15:30:00", 32), _160000("16:00:00", 33), _163000("16:30:00", 34), _170000("17:00:00", 35), _173000("17:30:00",
                        36), _180000("18:00:00", 37), _183000("18:30:00", 38), _190000("19:00:00", 39), _193000("19:30:00", 40), _200000("20:00:00", 41), _203000("20:30:00",
                            42), _210000("21:00:00", 43), _213000("21:30:00", 44), _220000("22:00:00", 45), _223000("22:30:00", 46), _230000("23:00:00", 47), _233000("23:30:00", 48);

    TIMEHOURS(String hour, int index) {
      this.hour = hour;
      this.index = index;
    }

    private final String hour;
    private final int index;

    public String getStringHour() {
      return this.hour;
    }

    public int getIndexHour() {
      return this.index;
    }
  }

  public enum VIEW {
    DAY, WEEK, MONTH, LIST;
  }

  @FindBy(css = ".fc-prev-button")
  private WebElement prevButton;

  @FindBy(css = ".fc-next-button")
  private WebElement nextButton;

  @FindBy(css = ".fc-today-button")
  private WebElement todayButton;

  @FindBy(css = ".fc-month-button")
  private WebElement monthButton;

  @FindBy(css = ".fc-basicWeek-button, .fc-agendaWeek-button")
  private WebElement weekButton;

  @FindBy(css = ".fc-basicDay-button, .fc-agendaDay-button")
  private WebElement dayButton;

  @FindBy(css = ".fc-listWeek-button")
  private WebElement listButton;

  @FindBy(css = ".fc-scroller .fc-bg .fc-day")
  private List<WebElement> dayOfWeek;

  @FindBy(css = ".fc-row .fc-day")
  private List<WebElement> allDay;

  @FindBy(css = ".fc-time-grid .fc-day")
  private List<WebElement> rowsTimeGrid;

  @FindBy(css = ".fc-slats tr")
  private List<WebElement> timeSlats;

  private final String eventsCss = ".fc-event";
  @FindBy(css = eventsCss)
  private List<WebElement> events;

  @FindBy(css = ".fc-more")
  private List<WebElement> fcMoreLinks;

  @FindBy(css = ".fc-center h2")
  private WebElement headerOfCalendar;

  // footer
  @FindBy(css = "#foot a")
  private List<WebElement> linksFooter;

  public void todayButtonClick() {
    new OButton(driver, todayButton).click();
  }

  public void nextButtonClick() {
    new OButton(driver, nextButton).click();
  }

  public void prevButtonClick() {
    new OButton(driver, prevButton).click();
  }

  public void monthButtonClick() {
    new OButton(driver, monthButton).click();
  }

  public void weekButtonClick() {
    new OButton(driver, weekButton).click();
  }

  public void dayButtonClick() {
    new OButton(driver, dayButton).click();
  }

  public void listButtonClick() {
    new OButton(driver, listButton).click();
  }

  public void buttonArrayClick(int time) {
    OButton[] buttonObj = { new OButton(driver, listButton), new OButton(driver, weekButton), new OButton(driver, dayButton), new OButton(driver, monthButton) };
    for (int i = 0; i < buttonObj.length; i++) {
      buttonObj[i].click();
      utils.waitTime(time);
    }
  }

  public void listFcMoreLinksClick() {
    LOG.info("List more links Click");
    for (WebElement w : fcMoreLinks) {
      w.click();
    }
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public List<LocalDate> getAllDayDates() {
    List<LocalDate> listDates = new ArrayList<LocalDate>();
    for (WebElement a : allDay) {
      listDates.add(LocalDate.parse(a.getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    return listDates;
  }

  public List<LocalDate> getDayOfWeekDate() {
    List<LocalDate> listDates = new ArrayList<LocalDate>();
    for (WebElement a : dayOfWeek) {
      LocalDate dataConvert = LocalDate.parse(a.getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      System.out.println(dataConvert.getDayOfWeek().getValue());
      listDates.add(dataConvert);
    }
    return listDates;
  }

  public boolean isDateOnCalendar(LocalDate localDate) {
    LOG.info("Check if date: " + localDate + " is on calendar");
    if (getAllDayDates().contains(localDate)) {
      LOG.info("Date: " + localDate + " is on calendar");
      return true;
    }
    LOG.info("Date: " + localDate + " is NOT on calendar");
    return false;
  }

  public void setDate(LocalDate localDate) {
    LocalDate currentDay = LocalDate.now();
    todayButtonClick();

    if (localDate.isEqual(currentDay)) {
      isDateOnCalendar(localDate);
    } else if (localDate.isBefore(currentDay)) {
      LOG.info("Date: " + localDate + " is before " + currentDay);
      while (isDateOnCalendar(localDate) == false) {
        if (isDateOnCalendar(localDate))
          break;
        prevButtonClick();
      }
      ;
    } else if (localDate.isAfter(currentDay)) {
      LOG.info("Date: " + localDate + " is after " + currentDay);
      while (isDateOnCalendar(localDate) == false) {
        if (isDateOnCalendar(localDate))
          break;
        nextButtonClick();
      }
      ;
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////
  public List<LocalDate> getRowsTimeGridDates() {
    List<LocalDate> listDates = new ArrayList<LocalDate>();
    for (WebElement a : rowsTimeGrid) {
      listDates.add(LocalDate.parse(a.getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    return listDates;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public List<WebElement> getEvents() {
    utils.waitForVisibilityOfElements(allDay);
    return events;
  }

  public Integer getEventsSize() {
    int size = 0;
    if (utils.isElementsPresent(By.cssSelector(eventsCss))) {
      size = events.size();
      return size;
    }

    return size;
  }

  public Integer getEventId(String title) {

    int index = 0;

    fcMoreLinks.get(0).click();
    for (int i = 0; i < events.size(); i++) {
      LOG.info(" title - > " + events.get(i).getText());

      if (events.get(i).getText().equals(title)) {
        index = i;
        LOG.info(" index - > " + i);
      }
    }
    return index;
  }

  public WebElement getHeaderOfCalendar() {
    return headerOfCalendar;
  }

  /////////////////////////////////////////////////////////////////////////////////

  public void moveWebElement(VIEW view, LocalDate localDate, TIMEHOURS timehours, String event) {
    // setDate(localDate);
    Actions action = new Actions(driver);

    if (view.equals(VIEW.DAY)) {
      dayButtonClick();

      for (WebElement element : events) {
        if (element.findElement(By.cssSelector(".fc-title")).getText().equals(event)) {
          LOG.info("Found event: " + event + ", move mouse to " + localDate + " " + timehours.getStringHour() + " " + timehours.getIndexHour());
          action.moveToElement(element).clickAndHold(element).moveToElement(timeSlats.get(timehours.getIndexHour())).release().build().perform();
          break;

        }
      }
    } else if (view.equals(VIEW.WEEK)) {
      weekButtonClick();
      for (int i = 0; i < rowsTimeGrid.size(); i++) {
        LocalDate date = LocalDate.parse(rowsTimeGrid.get(i).getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(localDate)) {
          LOG.info(date + " - " + localDate + " - " + i);
          for (WebElement element : events) {
            if (element.findElement(By.cssSelector(".fc-title")).getText().equals(event)) {
              LOG.info("Found event: " + event + ", move mouse to " + localDate + " " + timehours.getStringHour() + " " + timehours.getIndexHour());
              action.moveToElement(element).clickAndHold(element).moveToElement(rowsTimeGrid.get(i)).moveToElement(timeSlats.get(timehours.getIndexHour())).release().build().perform();
              break;

            }
          }
        }

      }

    } else if (view.equals(VIEW.MONTH)) {
      monthButtonClick();
      for (int i = 0; i < allDay.size(); i++) {
        LocalDate date = LocalDate.parse(allDay.get(i).getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(localDate)) {

          for (WebElement element : events) {
            if (element.findElement(By.cssSelector(".fc-title")).getText().equals(event)) {
              LOG.info("Found event: " + event + ", move mouse to " + localDate);
              action.moveToElement(element).clickAndHold(element).moveToElement(allDay.get(i)).release().build().perform();
              break;
            }
          }
          break;
        }

      }
    }
  }
}
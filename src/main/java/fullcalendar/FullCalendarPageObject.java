package fullcalendar;

import enums.CalendarEnums.TIMEHOURS;
import enums.CalendarEnums.VIEW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class FullCalendarPageObject extends PageObject {


  public FullCalendarPageObject(WebDriver driver) {
    super(driver);
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

  public FullCalendarPageObject todayButtonClick() {
    utils.linkClick(todayButton);
    return this;
  }

  public FullCalendarPageObject nextButtonClick() {
    utils.linkClick(nextButton);
    return this;
  }

  public FullCalendarPageObject prevButtonClick() {
    utils.linkClick(prevButton);
    return this;
  }

  public FullCalendarPageObject monthButtonClick() {
    utils.linkClick(monthButton);
    return this;
  }

  public FullCalendarPageObject weekButtonClick() {
    utils.linkClick(weekButton);
    return this;
  }

  public FullCalendarPageObject dayButtonClick() {
    utils.linkClick(dayButton);
    return this;
  }

  public FullCalendarPageObject listButtonClick() {
    utils.linkClick(listButton);
    return this;
  }

  public boolean checkIfMonthButtonIsActive() {
    return utils.isElementActive(monthButton);
  }

  public boolean checkIfWeekButtonIsActive() {
    return utils.isElementActive(weekButton);
  }

  public boolean checkIfDayButtonIsActive() {
    return utils.isElementActive(dayButton);
  }

  public boolean checkIfListButtonIsActive() {
    return utils.isElementActive(listButton);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public List<LocalDate> getAllDayDates() {
    List<LocalDate> listDates = new ArrayList<>();
    for (WebElement a : allDay) {
      listDates.add(LocalDate.parse(a.getAttribute("data-date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    return listDates;
  }

  public List<LocalDate> getDayOfWeekDate() {
    List<LocalDate> listDates = new ArrayList<>();
    for (WebElement a : dayOfWeek) {
      LocalDate dataConvert = LocalDate.parse(a.getAttribute("data-date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      System.out.println(dataConvert.getDayOfWeek().getValue());
      listDates.add(dataConvert);
    }
    return listDates;
  }

  public boolean isDateOnCalendar(LocalDate localDate) {
    //LOG.info("Check if date: " + localDate + " is on calendar");
    if (getAllDayDates().contains(localDate)) {
      //LOG.info("Date: " + localDate + " is on calendar");
      return true;
    }
    //LOG.info("Date: " + localDate + " is NOT on calendar");
    return false;
  }

  public void setDate(LocalDate localDate) {
    LocalDate currentDay = LocalDate.now();
    todayButtonClick();

    if (localDate.isEqual(currentDay)) {
      isDateOnCalendar(localDate);
    } else if (localDate.isBefore(currentDay)) {
      //LOG.info("Date: " + localDate + " is before " + currentDay);
      while (!isDateOnCalendar(localDate)) {
        if (isDateOnCalendar(localDate))
          break;
        prevButtonClick();
      }
    } else if (localDate.isAfter(currentDay)) {
      //LOG.info("Date: " + localDate + " is after " + currentDay);
      while (!isDateOnCalendar(localDate)) {
        if (isDateOnCalendar(localDate))
          break;
        nextButtonClick();
      }
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////
  public List<LocalDate> getRowsTimeGridDates() {
    List<LocalDate> listDates = new ArrayList<>();
    for (WebElement a : rowsTimeGrid) {
      listDates.add(LocalDate.parse(a.getAttribute("data-date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    return listDates;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public List<WebElement> getEvents() {
    utils.getWaits().waitForVisibilityOfElements(allDay);
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

    fcMoreLinks.get(0);
    for (int i = 0; i < events.size(); i++) {
      //LOG.info(" title - > " + events.get(i).getText());

      if (events.get(i).getText().equals(title)) {
        index = i;
        //LOG.info(" index - > " + i);
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
          //LOG.info("Found event: " + event + ", move mouse to " + localDate + " " + timehours.getStringHour() + " " + timehours.getIndexHour());
          action.moveToElement(element).clickAndHold(element).moveToElement(timeSlats.get(timehours.getIndexHour())).release().build().perform();
          break;

        }
      }
    } else if (view.equals(VIEW.WEEK)) {
      weekButtonClick();
      for (int i = 0; i < rowsTimeGrid.size(); i++) {
        LocalDate date = LocalDate.parse(rowsTimeGrid.get(i).getAttribute("data-date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(localDate)) {
          //LOG.info(date + " - " + localDate + " - " + i);
          for (WebElement element : events) {
            if (element.findElement(By.cssSelector(".fc-title")).getText().equals(event)) {
              //LOG.info("Found event: " + event + ", move mouse to " + localDate + " " + timehours.getStringHour() + " " + timehours.getIndexHour());
              action.moveToElement(element).clickAndHold(element).moveToElement(rowsTimeGrid.get(i)).moveToElement(timeSlats.get(timehours.getIndexHour())).release().build().perform();
              break;

            }
          }
        }

      }

    } else if (view.equals(VIEW.MONTH)) {
      monthButtonClick();
      for (WebElement anAllDay : allDay) {
        LocalDate date = LocalDate.parse(anAllDay.getAttribute("data-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(localDate)) {

          for (WebElement element : events) {
            if (element.findElement(By.cssSelector(".fc-title")).getText().equals(event)) {
              //LOG.info("Found event: " + event + ", move mouse to " + localDate);
              action.moveToElement(element).clickAndHold(element).moveToElement(anAllDay).release().build().perform();
              break;
            }
          }
          break;
        }

      }
    }
  }
}
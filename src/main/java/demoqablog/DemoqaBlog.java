package demoqablog;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;

import java.util.List;



public class DemoqaBlog extends OPage {

  private static final Logger LOG = Logger.getLogger(DemoqaBlog.class.getName());

  public DemoqaBlog(WebDriver driver) {
    super(driver);
  }

  private final String titlesEntryCss = "article .entry-title a";
  @FindBy(css = titlesEntryCss)
  private List<WebElement> titlesEntry;

  private final String dateEntryCss = "article .entry-date";
  @FindBy(css = dateEntryCss)
  private List<WebElement> dateEntry;

  private final String imageEntryCss = "article img.img-rounded";
  @FindBy(css = imageEntryCss)
  private List<WebElement> imageEntry;

  private final String textEntryCss = "article div.entry p";
  @FindBy(css = textEntryCss)
  private List<WebElement> textEntry;

  private final String readMoreEntryCss = "article a.btn:not(.btn-block)";
  @FindBy(css = readMoreEntryCss)
  private List<WebElement> readMoreEntry;

  public List<String> getEntryTitle() {
    LOG.info("Title of entrys: " + utils.getTextFromWebElementList(titlesEntry));
    return utils.getTextFromWebElementList(titlesEntry);
  }

  public void clickTitleEntry(String title) {
    LOG.info("Click on title blog article " + title);
    titlesEntry.get(utils.getId(titlesEntry, title)).click();
  }

  public void clickDateEntry(String title) {
    LOG.info("Click on date blog article " + title);
    dateEntry.get(utils.getId(titlesEntry, title)).click();
  }

  public void clickImageEntry(String title) {
    LOG.info("Click on image blog article " + title);
    imageEntry.get(utils.getId(titlesEntry, title)).click();
  }

  public void clickReadMoreLinkEntry(String title) {
    LOG.info("Click on [Read more] button blog article " + title);
    readMoreEntry.get(utils.getId(titlesEntry, title)).click();
  }
}

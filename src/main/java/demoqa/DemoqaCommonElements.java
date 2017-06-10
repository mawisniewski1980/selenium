package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaCommonElements extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaCommonElements.class.getName());

  public DemoqaCommonElements(WebDriver driver) {
    super(driver);
  }

  private final String titleCss = ".entry-title";
  @FindBy(css = titleCss)
  private WebElement title;

  private final String tabsCss = "#tabs";
  @FindBy(css = tabsCss)
  private WebElement tabs;

  private final String tabsLinksLiCss = "#tabs ul[role='tablist'] li";
  @FindBy(css = tabsLinksLiCss)
  private List<WebElement> tabsLinksLi;

  private final String tabsLinksACss = "#tabs ul[role='tablist'] li a";
  @FindBy(css = tabsLinksACss)
  private List<WebElement> tabsLinksA;

  private final String contenerCss = ".inside_contain";
  @FindBy(css = contenerCss)
  private WebElement contener;

  public String getEntryTitle() {
    LOG.info("Title of entry: " + title.getText());
    return title.getText();
  }

  public void tabsLinkClick(String title) {
    if (!(tabsLinksLi.get(utils.getId(tabsLinksA, title)).getAttribute("class").contains("ui-state-active"))) {
      utils.linkClick(tabsLinksA, title);
    } else {
      LOG.info("Tab '" + title + "' is active.");
    }
  }

  public WebElement getContener() {
    return contener;
  }

}

package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

import java.util.List;



public class DemoqaCommonElements extends PageObject {


  public DemoqaNavbar demoqaNavbar;
  public DemoqaPageObjectMenu demoqaMenu;

  public DemoqaCommonElements(WebDriver driver) {
    super(driver);
    this.demoqaNavbar = new DemoqaNavbar(driver);
    this.demoqaMenu = new DemoqaPageObjectMenu(driver);
  }

  private final String titleCss = ".entry-title";
  @FindBy(css = titleCss)
  private WebElement title;

  private final String tabsCss = "#tabs";
  @FindBy(css = tabsCss)
  private WebElement tabs;

/*  private final String tabsLinksLiCss = "#tabs ul[role='tablist'] li";
  @FindBy(css = tabsLinksLiCss)
  private List<WebElement> tabsLinksLi;*/

  private final String tabsLinksACss = "#tabs ul[role='tablist'] li a";
  @FindBy(css = tabsLinksACss)
  private List<WebElement> tabsLinksA;

  public String getEntryTitle() {
    logger.info("Title of entry: " + title.getText());
    return title.getText();
  }

  public void tabsLinkClick(String title) {
    if (!(tabsLinksA.get(utils.getId(tabsLinksA, title)).getAttribute("class").contains("ui-state-active"))) {
      utils.linkClick(tabsLinksA, title);
    } else {
      logger.info("Tab '" + title + "' is active.");
    }
  }

}

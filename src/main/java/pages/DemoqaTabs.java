package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstracts.AbstractPage;

import java.util.List;



public class DemoqaTabs extends AbstractPage {



  public DemoqaTabs(WebDriver driver) {
    super(driver);
  }

  private final String tabsCss = "#tabs222";
  @FindBy(css = tabsCss)
  private WebElement tabs;

  private final String tabsLinksCss = "#tabs222 ul[role='tablist'] li";
  @FindBy(css = tabsLinksCss)
  private List<WebElement> tabsLinks;

  private final String tabsContent1Css = "#tabs222 #tabs-1 p";
  @FindBy(css = tabsContent1Css)
  private WebElement tabsContent1;

  private final String tabsContent2Css = "#tabs222 #tabs-2 p";
  @FindBy(css = tabsContent2Css)
  private WebElement tabsContent2;

  private final String tabsContent3Css = "#tabs222 #tabs-3 p";
  @FindBy(css = tabsContent3Css)
  private WebElement tabsContent3;

  public WebElement getTabs() {
    return tabs;
  }

  public String getTabsContent1() {
    return utils.getText(tabsContent1);
  }

  public String getTabsContent2() {
    return utils.getText(tabsContent2);
  }

  public String getTabsContent3() {
    return utils.getText(tabsContent3);
  }

  public void tabsLinkClick(String title) {
    utils.linkClick(tabsLinks, title);
  }

}

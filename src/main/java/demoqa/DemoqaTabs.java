package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaTabs extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaTabs.class.getName());

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
    return tabsContent1.getText();
  }

  public String getTabsContent2() {
    return tabsContent2.getText();
  }

  public String getTabsContent3() {
    return tabsContent3.getText();
  }

  public void tabsLinkClick(String title) {
    utils.linkClick(tabsLinks, title);
  }

}

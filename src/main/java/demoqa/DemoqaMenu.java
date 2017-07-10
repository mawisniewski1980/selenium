package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

import java.util.List;

public class DemoqaMenu extends PageObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaMenu.class.getName());

  public DemoqaMenu(WebDriver driver) {
    super(driver);
  }

  private final String simpleMenuListItemsCss = "#tabs-1 #navigate ul li a";
  @FindBy(css = simpleMenuListItemsCss)
  private List<WebElement> simpleMenuListItems;

  private final String menuWithSubmenuListItemsACss = "#tabs-2 ul.top-level>li>a";
  @FindBy(css = menuWithSubmenuListItemsACss)
  private List<WebElement> menuWithSubmenuListItemsA;

  private final String menuWithSubmenuListItemsLiCss = "#tabs-2 ul.top-level>li";
  @FindBy(css = menuWithSubmenuListItemsLiCss)
  private List<WebElement> menuWithSubmenuListItemsLi;

  private final String menuWithSubmenuListSubLevelUlCss = "ul.sub-level>li>a";
  @FindBy(css = menuWithSubmenuListSubLevelUlCss)
  private List<WebElement> menuWithSubmenuListSubLevelUl;

  public DemoqaMenu hoverLinkSimpleMenuItem(String text) {
    utils.actions.moveTo(simpleMenuListItems.get(utils.getId(simpleMenuListItems,text)));
    return this;
  }

  public DemoqaMenu hoverMenuWithSubmenuListSubLevel(String text, String subtext) {

    utils.actions.moveTo(menuWithSubmenuListItemsA.get(utils.getId(menuWithSubmenuListItemsA,text)));
    if(subtext != null) {
      List<WebElement> listE = utils.findNextElementsByCssSelector(menuWithSubmenuListItemsLi.get(utils.getId(menuWithSubmenuListItemsA,text)), menuWithSubmenuListSubLevelUlCss);
      utils.actions.moveTo(listE.get(utils.getId(listE, subtext)));
    }
    return this;
  }

}

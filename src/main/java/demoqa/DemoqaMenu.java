package demoqa;

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

  private final String menuWithSubmenuListTopLevelLiCss = "#tabs-2 ul.top-level>li";
  @FindBy(css = menuWithSubmenuListTopLevelLiCss)
  private List<WebElement> menuWithSubmenuListTopLevelLi;

  private final String menuWithSubmenuListSubLevelUlCss = "ul.sub-level";
  @FindBy(css = menuWithSubmenuListSubLevelUlCss)
  private WebElement menuWithSubmenuListSubLevelUl;

  private final String menuWithSubmenuListItemsCss = "#tabs-2 ul.top-level>li>a";
  @FindBy(css = menuWithSubmenuListItemsCss)
  private List<WebElement> menuWithSubmenuListItems;
}

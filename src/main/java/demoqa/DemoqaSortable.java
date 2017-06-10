package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaSortable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaSortable.class.getName());

  public DemoqaSortable(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityItemsCss = "#sortable li";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String connectListsOneItemsCss = "#sortable1 li";
  @FindBy(css = connectListsOneItemsCss)
  private List<WebElement> connectListsOneItems;

  private final String connectListsTwoItemsCss = "#sortable2 li";
  @FindBy(css = connectListsTwoItemsCss)
  private List<WebElement> connectListsTwoItems;

  private final String sortableGridItemsCss = "#sortable_grid li";
  @FindBy(css = sortableGridItemsCss)
  private List<WebElement> sortableGridItems;

  private final String portletItemsListCss = ".portlet";
  @FindBy(css = portletItemsListCss)
  private List<WebElement> portletItemsList;

  private final String portletItemsHeaderCss = ".portlet-header";
  @FindBy(css = portletItemsHeaderCss)
  private List<WebElement> portletItemsHeader;

  private final String portletItemsHeaderToggleCss = "span";
  @FindBy(css = portletItemsHeaderToggleCss)
  private List<WebElement> portletItemsHeaderToggle;

}

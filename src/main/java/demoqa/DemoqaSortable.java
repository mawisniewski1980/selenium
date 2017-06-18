package demoqa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;
import utilsobjects.ODraggable;

public class DemoqaSortable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaSortableTest.class.getName());

  public DemoqaSortable(WebDriver driver) {
    super(driver);
  }

  private final String defaultFunctionalityItemsCss = "#sortable li";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String connectListOneCss = "#sortable1";
  @FindBy(css = connectListOneCss)
  private WebElement connectListOne;

  private final String connectListTwoCss = "#sortable2";
  @FindBy(css = connectListTwoCss)
  private WebElement connectListTwo;

  private final String connectListsDefaultItemsCss = ".ui-state-default";
  private final String connectListsHighlightItemsCss = ".ui-state-highlight";
  private final String connectListsItemsCss = "LI";

  private final String sortableGridItemsCss = "#sortable_grid li";
  @FindBy(css = sortableGridItemsCss)
  private List<WebElement> sortableGridItems;

  private final String portletItemsColumnCss = ".column";
  @FindBy(css = portletItemsColumnCss)
  private List<WebElement> portletItemsColumn;

  private final String portletItemsListCss = ".portlet";
  private final String portletItemsHeaderCss = ".portlet-header";
  private final String portletItemsHeaderToggleCss = ".ui-icon-minusthick";

  public List<String> getDefaultFunctionalityItemsText() {
    return utils.getStringsFromWebElements(defaultFunctionalityItems);
  }

  public List<String> getConnectListsDefaultItemsText() {
    List<WebElement> theList = utils.findNextElementsByCssSelector(connectListOne, connectListsDefaultItemsCss);
    return utils.getStringsFromWebElements(theList);
  }

  public List<String> getConnectListsHighlightItemsText() {
    List<WebElement> theList = utils.findNextElementsByCssSelector(connectListTwo, connectListsHighlightItemsCss);
    return utils.getStringsFromWebElements(theList);
  }

  public List<String> getConnectListsAllItemsOnDefaultText() {
    List<WebElement> theList = utils.findNextElementsByCssSelector(connectListOne, By.tagName(connectListsItemsCss));
    return utils.getStringsFromWebElements(theList);
  }

  public List<String> getConnectListsAllItemsOnHighlightText() {
    List<WebElement> theList = utils.findNextElementsByCssSelector(connectListTwo, By.tagName(connectListsItemsCss));
    return utils.getStringsFromWebElements(theList);
  }

  public List<String> getSortableGridItemsText() {
    return utils.getStringsFromWebElements(sortableGridItems);
  }

  public List<String> getPortletItemsText() {
    List<String> listStrings = new ArrayList<String>();
    int sumOfColumns = portletItemsColumn.size();
    for (int i = 0; i < sumOfColumns; i++) {
      List<WebElement> theList = utils.findNextElementsByCssSelector(portletItemsColumn.get(i), portletItemsListCss);
      int sumOfPortlets = theList.size();
      // LOG.info("In column " + (i + 1) + " is " + sumOfPortlets + " portlet/portlets");
      for (int j = 0; j < sumOfPortlets; j++) {
        // LOG.info("Title: " + utils.getStringsFromWebElements(utils.findNextElementsByCssSelector(theList.get(j), portletItemsHeaderCss)));
        listStrings.addAll(utils.getStringsFromWebElements(utils.findNextElementsByCssSelector(theList.get(j), portletItemsHeaderCss)));
      }
    }
    return listStrings;
  }

  public DemoqaSortable dragDefaultFunctionalityItem(String item1, String item2) {
    ODraggable obj1 = new ODraggable(defaultFunctionalityItems.get(utils.getId(defaultFunctionalityItems, item1)));
    ODraggable obj2 = new ODraggable(defaultFunctionalityItems.get(utils.getId(defaultFunctionalityItems, item2)));
    utils.moveByY(obj1, (int) obj1.getDistanceCenterToCenter(obj2.getElement()) + 1);
    return this;
  }

  public DemoqaSortable dragConnectListsOneItem(String item1, String item2) {
    List<WebElement> itemsWeb1 = utils.findNextElementsByCssSelector(connectListOne, connectListsDefaultItemsCss);
    ODraggable obj1 = new ODraggable(itemsWeb1.get(utils.getId(itemsWeb1, item1)));
    ODraggable obj2 = new ODraggable(itemsWeb1.get(utils.getId(itemsWeb1, item2)));
    utils.moveByY(obj1, (int) obj1.getDistanceCenterToCenter(obj2.getElement()) + 1);
    return this;
  }

  public DemoqaSortable dragConnectListsTwoItem(String item1, String item2) {
    List<WebElement> itemsWeb1 = utils.findNextElementsByCssSelector(connectListTwo, connectListsHighlightItemsCss);
    ODraggable obj1 = new ODraggable(itemsWeb1.get(utils.getId(itemsWeb1, item1)));
    ODraggable obj2 = new ODraggable(itemsWeb1.get(utils.getId(itemsWeb1, item2)));
    utils.moveByY(obj1, (int) obj1.getDistanceCenterToCenter(obj2.getElement()) + 1);
    return this;
  }

  public DemoqaSortable dragConnectOneColumnItemToTwoColumn(String item1, String item2) {
    List<WebElement> items1Web1 = utils.findNextElementsByCssSelector(connectListOne, connectListsDefaultItemsCss);
    ODraggable obj1 = new ODraggable(items1Web1.get(utils.getId(items1Web1, item1)));

    List<WebElement> items2Web1 = utils.findNextElementsByCssSelector(connectListTwo, connectListsHighlightItemsCss);
    ODraggable obj2 = new ODraggable(items2Web1.get(utils.getId(items2Web1, item2)));

    utils.moveElementFromCenterToCenter(obj1, obj2);
    return this;
  }

  public DemoqaSortable dragConnectTwoColumnItemToOneColumn(String item1, String item2) {
    List<WebElement> items1Web1 = utils.findNextElementsByCssSelector(connectListOne, connectListsDefaultItemsCss);
    ODraggable obj1 = new ODraggable(items1Web1.get(utils.getId(items1Web1, item1)));

    List<WebElement> items2Web1 = utils.findNextElementsByCssSelector(connectListTwo, connectListsHighlightItemsCss);
    ODraggable obj2 = new ODraggable(items2Web1.get(utils.getId(items2Web1, item2)));

    utils.moveElementFromCenterToCenter(obj2, obj1);
    return this;
  }

  public DemoqaSortable dragSortableGridItems(String item1, String item2) {

    ODraggable obj1 = new ODraggable(sortableGridItems.get(utils.getId(sortableGridItems, item1)));
    ODraggable obj2 = new ODraggable(sortableGridItems.get(utils.getId(sortableGridItems, item2)));

    utils.waitTime(4);
    return this;
  }
}

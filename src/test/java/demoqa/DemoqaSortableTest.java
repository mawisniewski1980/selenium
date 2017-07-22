package demoqa;

import enums.PageUrls.PageUrl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import testobject.OTest;

import java.util.List;
import java.util.Map;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class DemoqaSortableTest extends OTest {

  private static final Logger LOG = Logger.getLogger(DemoqaSortableTest.class.getName());

  private DemoqaSortable sortable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    sortable = new DemoqaSortable(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaMenu.sortableLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Sortable page title:", "Sortable | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Sortable entry title:", "Sortable", commonElements.getEntryTitle());
  }

  @Test
  public void dragDefaultFunctionality() {

    commonElements.tabsLinkClick("Default functionality");

    List<String> listBefore = sortable.getDefaultFunctionalityItemsText();
    LOG.info("List before: " + listBefore);

    sortable.dragDefaultFunctionalityItem("Item 1", "Item 4");

    List<String> listAfter = sortable.getDefaultFunctionalityItemsText();
    LOG.info("List after: " + listAfter);

    assertNotEquals(listBefore, listAfter);
  }

  @Test
  public void dragItemsInLeftAndRightConnectList() {

    commonElements.tabsLinkClick("Connect Lists");

    List<String> listLeftBefore = sortable.getConnectListsDefaultItemsText();
    List<String> listRightBefore = sortable.getConnectListsHighlightItemsText();
    LOG.info("List Left before: " + listLeftBefore);
    LOG.info("List Right before: " + listRightBefore);

    sortable.dragConnectListsOneItem("Item 2", "Item 4");
    sortable.dragConnectListsTwoItem("Item 1", "Item 3");

    List<String> listLeftAfter = sortable.getConnectListsDefaultItemsText();
    List<String> listRightAfter = sortable.getConnectListsHighlightItemsText();
    LOG.info("List Left after: " + listLeftAfter);
    LOG.info("List Right after: " + listRightAfter);

    assertNotEquals(listLeftBefore, listLeftAfter);
    assertNotEquals(listRightBefore, listRightAfter);
  }

  @Test
  public void dragItemFromLeftToRightConnectList() {

    commonElements.tabsLinkClick("Connect Lists");

    List<String> listAllLeftBefore = sortable.getConnectListsAllItemsOnDefaultText();
    List<String> listAllRightBefore = sortable.getConnectListsAllItemsOnHighlightText();
    LOG.info("List All left before: " + listAllLeftBefore);
    LOG.info("List All right before: " + listAllRightBefore);

    List<String> listLeftBefore = sortable.getConnectListsDefaultItemsText();
    LOG.info("List Left before: " + listLeftBefore);

    sortable.dragConnectOneColumnItemToTwoColumn("Item 1", "Item 4");

    List<String> listLeftAfter = sortable.getConnectListsDefaultItemsText();
    LOG.info("List Left after: " + listLeftAfter);

    assertNotEquals(listLeftBefore, listLeftAfter);
  }

  @Test
  public void dragItemFromRightToLeftConnectList() {

    commonElements.tabsLinkClick("Connect Lists");

    List<String> listAllLeftBefore = sortable.getConnectListsAllItemsOnDefaultText();
    List<String> listAllRightBefore = sortable.getConnectListsAllItemsOnHighlightText();
    LOG.info("List All left before: " + listAllLeftBefore);
    LOG.info("List All right before: " + listAllRightBefore);

    List<String> listRightBefore = sortable.getConnectListsHighlightItemsText();
    LOG.info("List right before: " + listRightBefore);

    sortable.dragConnectTwoColumnItemToOneColumn("Item 4", "Item 2");

    List<String> listRightAfter = sortable.getConnectListsHighlightItemsText();
    LOG.info("List right after: " + listRightAfter);

    assertNotEquals(listRightBefore, listRightAfter);

  }

  @Test
  public void dragDisplayAsGrid() {
    commonElements.tabsLinkClick("Display as grid");

    List<String> listBefore = sortable.getSortableGridItemsText();
    LOG.info("List before: " + listBefore);

    sortable.dragSortableGridItems("1", 150, 100, 3);

    List<String> listAfter = sortable.getSortableGridItemsText();
    LOG.info("List after: " + listAfter);

    assertNotEquals(listBefore, listAfter);
  }

  @Test
  public void checkCountOfPortletsInColumns() {

    commonElements.tabsLinkClick("Portlets");
    Map<Integer, String> mapBefore = sortable.getPortletMapItemsText();

    sortable.dragPortletsToAnotherColumn("Feeds", 2);
    // sortable.dragPortletsToAnotherColumn("News", 1);

    Map<Integer, String> mapAfter = sortable.getPortletMapItemsText();

    assertNotSame(mapBefore, mapAfter);
  }
}

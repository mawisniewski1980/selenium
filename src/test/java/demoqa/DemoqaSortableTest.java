package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaSortableTest extends TestObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaSortableTest.class.getName());

  private DemoqaSortable sortable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    commonElements = new DemoqaCommonElements(driver);
    sortable = new DemoqaSortable(driver);
    new DemoqaPageMenu(driver).sortableLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Sortable | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Sortable");
  }

  @Test
  public void dragDefaultFunctionality() {

    commonElements.tabsLinkClick("Default functionality");

    List<String> listBefore = sortable.getDefaultFunctionalityItemsText();
    LOG.info("List before: " + listBefore);

    sortable.dragDefaultFunctionalityItem("Item 1", "Item 4");

    List<String> listAfter = sortable.getDefaultFunctionalityItemsText();
    LOG.info("List after: " + listAfter);

    assertThat(listBefore).isNotEqualTo(listAfter);
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

    assertThat(listLeftBefore).isNotEqualTo(listLeftAfter);
    assertThat(listRightBefore).isNotEqualTo(listRightAfter);
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

    assertThat(listLeftBefore).isNotEqualTo(listLeftAfter);

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

    assertThat(listRightBefore).isNotEqualTo(listRightAfter);

  }

  @Test
  public void dragDisplayAsGrid() {
    commonElements.tabsLinkClick("Display as grid");

    List<String> listBefore = sortable.getSortableGridItemsText();
    LOG.info("List before: " + listBefore);

    sortable.dragSortableGridItems("1", 150, 100, 3);

    List<String> listAfter = sortable.getSortableGridItemsText();
    LOG.info("List after: " + listAfter);

    assertThat(listBefore).isNotEqualTo(listAfter);
  }

  @Test
  public void checkCountOfPortletsInColumns() {

    commonElements.tabsLinkClick("Portlets");
    Map<Integer, String> mapBefore = sortable.getPortletMapItemsText();

    sortable.dragPortletsToAnotherColumn("Feeds", 2);
    // sortable.dragPortletsToAnotherColumn("News", 1);

    Map<Integer, String> mapAfter = sortable.getPortletMapItemsText();

    assertThat(mapBefore).isNotSameAs(mapAfter);
  }
}

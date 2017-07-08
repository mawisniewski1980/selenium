package demoqa;

import com.google.common.collect.ImmutableList;
import enums.PageUrls.PageUrl;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DemoqaSelectableTest extends TestObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaSelectableTest.class.getName());

  private DemoqaSelectable selectable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    selectable = new DemoqaSelectable(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaMenu.selectableLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Selectable page title:", "Selectable | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Selectable entry title:", "Selectable", commonElements.getEntryTitle());
  }

  @Test
  public void selectItemsDefaltFunctionalityByClick() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }

    selectable.selectDefaltFunctionalityOneItem("Item 1");
    selectable.selectDefaltFunctionalityOneItem("Item 6");

    for (int i = 1; i < 8; i++) {
      if (i == 6)
        assertTrue(selectable.isDefaltFunctionalityItemSelected("Item " + i));
      else
        assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }
  }

  @Test
  public void selectItemsDefaltFunctionalityByDrag() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }

    selectable.selectDefaltFunctionalityMoreItems("Item 3", "Item 6");

    for (int i = 1; i < 8; i++) {
      if (i > 2 && i < 7)
        assertTrue(selectable.isDefaltFunctionalityItemSelected("Item " + i));
      else
        assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }
  }

  @Test
  public void selectDisplayAsGridByClick() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }

    selectable.selectDisplayAsGridOneItem("1");
    selectable.selectDisplayAsGridOneItem("5");
    selectable.selectDisplayAsGridOneItem("12");

    for (int i = 1; i < 13; i++) {
      if (i == 12)
        assertTrue(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
      else
        assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }
  }

  @Test
  public void selectDisplayAsGridByDrag() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }

    selectable.selectDisplayAsGridMoreItems("6", "12");

    for (int i = 1; i < 13; i++) {
      if (i == 6 || i == 7 || i == 8 || i == 10 || i == 11 || i == 12)
        assertTrue(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
      else
        assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }
  }

  @Test
  public void selectItemsSerializeByClick() {

    commonElements.tabsLinkClick("Serialize");

    assertTrue(selectable.getSerializeSelectedList().contains("none"));

    for (int i = 1; i < 7; i++) {
      assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    selectable.selectSerializeFeedbackOneItem("Item 1");
    selectable.selectSerializeFeedbackOneItem("Item 5");

    for (int i = 1; i < 7; i++) {
      if (i == 5)
        assertTrue(selectable.isSerializeFeedbackItemSelected("Item " + i));
      else
        assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    assertTrue(selectable.getSerializeSelectedList().contains("5"));
  }

  @Test
  public void selectItemsSerializeByDrag() {

    commonElements.tabsLinkClick("Serialize");

    assertTrue(selectable.getSerializeSelectedList().contains("none"));

    for (int i = 1; i < 7; i++) {
      assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    selectable.selectSerializeFeedbackMoreItems("Item 1", "Item 2");

    for (int i = 1; i < 7; i++) {
      if (i > 0 && i < 3)
        assertTrue(selectable.isSerializeFeedbackItemSelected("Item " + i));
      else
        assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    assertTrue(selectable.getSerializeSelectedList().containsAll(ImmutableList.of("1", "2")));
  }

  @Test
  public void selectItemsDefaltFunctionalityByClickWithCTRL() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }

    List<String> selectedList = ImmutableList.of("Item 1", "Item 4", "Item 7");
    selectable.selectDefaltFunctionalityMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 8; i++) {
      if (i == 1 || i == 4 || i == 7)
        assertTrue(selectable.isDefaltFunctionalityItemSelected("Item " + i));
      else
        assertFalse(selectable.isDefaltFunctionalityItemSelected("Item " + i));
    }
  }

  @Test
  public void selectDisplayAsGridByByClickWithCTRL() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }

    List<String> selectedList = ImmutableList.of("3", "9", "8");
    selectable.selectDisplayAsGridMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 13; i++) {
      if (i == 3 || i == 9 || i == 8)
        assertTrue(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
      else
        assertFalse(selectable.isDisplayAsGridItemSelected(Integer.toString(i)));
    }
  }

  @Test
  public void selectItemsSerializeByClickWithCTR() {

    commonElements.tabsLinkClick("Serialize");

    assertTrue(selectable.getSerializeSelectedList().contains("none"));

    for (int i = 1; i < 7; i++) {
      assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    List<String> selectedList = ImmutableList.of("Item 1", "Item 6");
    selectable.selectSerializeFeedbackMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 7; i++) {
      if (i == 1 || i == 6)
        assertTrue(selectable.isSerializeFeedbackItemSelected("Item " + i));
      else
        assertFalse(selectable.isSerializeFeedbackItemSelected("Item " + i));
    }

    assertTrue(selectable.getSerializeSelectedList().containsAll(ImmutableList.of("1", "6")));
  }

}

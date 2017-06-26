package demoqa;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import enums.PageUrls.PageUrl;
import testobject.TestObject;

public class DemoqaSelectableTest extends TestObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaSelectableTest.class.getName());

  private DemoqaSelectable selectable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    commonElements = new DemoqaCommonElements(driver);
    selectable = new DemoqaSelectable(driver);
    new DemoqaPageMenu(driver).selectableLinkClick();
  }

  @Test
  public void getTitle() {
    assertThat(utils.getTitle()).isEqualTo("Selectable | Demoqa");
  }

  @Test
  public void getEntryTitle() {
    assertThat(commonElements.getEntryTitle()).isEqualTo("Selectable");
  }

  @Test
  public void selectItemsDefaltFunctionalityByClick() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }

    selectable.selectDefaltFunctionalityOneItem("Item 1");
    selectable.selectDefaltFunctionalityOneItem("Item 6");

    for (int i = 1; i < 8; i++) {
      if (i == 6)
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }
  }

  @Test
  public void selectItemsDefaltFunctionalityByDrag() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }

    selectable.selectDefaltFunctionalityMoreItems("Item 3", "Item 6");

    for (int i = 1; i < 8; i++) {
      if (i > 2 && i < 7)
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }
  }

  @Test
  public void selectDisplayAsGridByClick() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }

    selectable.selectDisplayAsGridOneItem("1");
    selectable.selectDisplayAsGridOneItem("5");
    selectable.selectDisplayAsGridOneItem("12");

    for (int i = 1; i < 13; i++) {
      if (i == 12)
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isTrue();
      else
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }
  }

  @Test
  public void selectDisplayAsGridByDrag() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }

    selectable.selectDisplayAsGridMoreItems("6", "12");

    for (int i = 1; i < 13; i++) {
      if (i == 6 || i == 7 || i == 8 || i == 10 || i == 11 || i == 12)
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isTrue();
      else
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }
  }

  @Test
  public void selectItemsSerializeByClick() {

    commonElements.tabsLinkClick("Serialize");

    assertThat(selectable.getSerializeSelectedList()).contains("none");

    for (int i = 1; i < 7; i++) {
      assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    selectable.selectSerializeFeedbackOneItem("Item 1");
    selectable.selectSerializeFeedbackOneItem("Item 5");

    for (int i = 1; i < 7; i++) {
      if (i == 5)
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    assertThat(selectable.getSerializeSelectedList()).contains("5");
  }

  @Test
  public void selectItemsSerializeByDrag() {

    commonElements.tabsLinkClick("Serialize");

    assertThat(selectable.getSerializeSelectedList()).contains("none");

    for (int i = 1; i < 7; i++) {
      assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    selectable.selectSerializeFeedbackMoreItems("Item 1", "Item 2");

    for (int i = 1; i < 7; i++) {
      if (i > 0 && i < 3)
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    assertThat(selectable.getSerializeSelectedList()).containsAll(ImmutableList.of("1", "2"));
  }

  @Test
  public void selectItemsDefaltFunctionalityByClickWithCTRL() {

    commonElements.tabsLinkClick("Default functionality");

    for (int i = 1; i < 8; i++) {
      assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }

    List<String> selectedList = ImmutableList.of("Item 1", "Item 4", "Item 7");
    selectable.selectDefaltFunctionalityMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 8; i++) {
      if (i == 1 || i == 4 || i == 7)
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isDefaltFunctionalityItemSelected("Item " + i)).isFalse();
    }
  }

  @Test
  public void selectDisplayAsGridByByClickWithCTRL() {

    commonElements.tabsLinkClick("Display as grid");

    for (int i = 1; i < 13; i++) {
      assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }

    List<String> selectedList = ImmutableList.of("3", "9", "8");
    selectable.selectDisplayAsGridMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 13; i++) {
      if (i == 3 || i == 9 || i == 8)
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isTrue();
      else
        assertThat(selectable.isDisplayAsGridItemSelected(Integer.toString(i))).isFalse();
    }
  }

  @Test
  public void selectItemsSerializeByClickWithCTR() {

    commonElements.tabsLinkClick("Serialize");

    assertThat(selectable.getSerializeSelectedList()).contains("none");

    for (int i = 1; i < 7; i++) {
      assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    List<String> selectedList = ImmutableList.of("Item 1", "Item 6");
    selectable.selectSerializeFeedbackMoreItemsWithCTRL(selectedList);

    for (int i = 1; i < 7; i++) {
      if (i == 1 || i == 6)
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isTrue();
      else
        assertThat(selectable.isSerializeFeedbackItemSelected("Item " + i)).isFalse();
    }

    assertThat(selectable.getSerializeSelectedList()).containsAll(ImmutableList.of("1", "6"));
  }

}

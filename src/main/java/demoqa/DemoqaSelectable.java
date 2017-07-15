package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.OPage;
import utilsobjects.ODraggable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoqaSelectable extends OPage {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaSelectable.class.getName());

  public DemoqaSelectable(WebDriver driver) {
    super(driver);
  }

  private final String selectedCss = "ui-selected";

  private final String defaultFunctionalityItemsCss = "#selectable li";
  @FindBy(css = defaultFunctionalityItemsCss)
  private List<WebElement> defaultFunctionalityItems;

  private final String displayAsGridItemsCss = "#selectable_grid li";
  @FindBy(css = displayAsGridItemsCss)
  private List<WebElement> displayAsGridItems;

  private final String serializeFeedbackCss = "#feedback #select-result";
  @FindBy(css = serializeFeedbackCss)
  private WebElement serializeFeedback;

  private final String serializeFeedbackItemsCss = "#selectable-serialize li";
  @FindBy(css = serializeFeedbackItemsCss)
  private List<WebElement> serializeFeedbackItems;

  public DemoqaSelectable selectDefaltFunctionalityOneItem(String title) {
    LOG.info("Select one item " + title + " on Defalt Functionality");
    utils.actions.selectItemByClick(defaultFunctionalityItems, title);
    return this;
  }

  public DemoqaSelectable selectDisplayAsGridOneItem(String title) {
    LOG.info("Select one item " + title + " on Display As Grid");
    utils.actions.selectItemByClick(displayAsGridItems, title);
    return this;
  }

  public DemoqaSelectable selectSerializeFeedbackOneItem(String title) {
    LOG.info("Select one item " + title + " on Serialize Feedback");
    utils.actions.selectItemByClick(serializeFeedbackItems, title);
    return this;
  }

  public boolean isDefaltFunctionalityItemSelected(String title) {
    LOG.info("Is " + title + " is selected on Defalt Functionality");
    return defaultFunctionalityItems.get(utils.getId(defaultFunctionalityItems, title)).getAttribute("class").contains(selectedCss);
  }

  public boolean isDisplayAsGridItemSelected(String title) {
    LOG.info("Is " + title + " is selected on Display As Grid");
    return displayAsGridItems.get(utils.getId(displayAsGridItems, title)).getAttribute("class").contains(selectedCss);
  }

  public boolean isSerializeFeedbackItemSelected(String title) {
    LOG.info("Is " + title + " is selected on Serialize Feedback");
    return serializeFeedbackItems.get(utils.getId(serializeFeedbackItems, title)).getAttribute("class").contains(selectedCss);
  }

  public DemoqaSelectable selectDefaltFunctionalityMoreItems(String one, String two) {
    LOG.info("Select more items from item " + one + " to " + two + " on Defalt Functionality");
    ODraggable objOne = new ODraggable(defaultFunctionalityItems.get(utils.getId(defaultFunctionalityItems, one)));
    ODraggable objTwo = new ODraggable(defaultFunctionalityItems.get(utils.getId(defaultFunctionalityItems, two)));
    utils.actions.selectFromCenterToCenter(objOne, objTwo);
    return this;
  }

  public DemoqaSelectable selectDisplayAsGridMoreItems(String one, String two) {
    LOG.info("Select more items from item " + one + " to " + two + " on Display As Grid");
    ODraggable objOne = new ODraggable(displayAsGridItems.get(utils.getId(displayAsGridItems, one)));
    ODraggable objTwo = new ODraggable(displayAsGridItems.get(utils.getId(displayAsGridItems, two)));
    utils.actions.selectFromCenterToCenter(objOne, objTwo);
    return this;
  }

  public DemoqaSelectable selectSerializeFeedbackMoreItems(String one, String two) {
    LOG.info("Select more items from item " + one + " to " + two + " on Serialize Feedback");
    ODraggable objOne = new ODraggable(serializeFeedbackItems.get(utils.getId(serializeFeedbackItems, one)));
    ODraggable objTwo = new ODraggable(serializeFeedbackItems.get(utils.getId(serializeFeedbackItems, two)));
    utils.actions.selectFromCenterToCenter(objOne, objTwo);
    return this;
  }

  public ArrayList<String> getSerializeSelectedList() {
    return new ArrayList<String>(Arrays.asList(serializeFeedback.getText().split("#")));
  }

  public DemoqaSelectable selectDefaltFunctionalityMoreItemsWithCTRL(List<String> titles) {
    LOG.info("Select items " + titles + " on Defalt Functionality");
    utils.actions.selectItemByClickWithCTRL(defaultFunctionalityItems, titles);
    return this;
  }

  public DemoqaSelectable selectDisplayAsGridMoreItemsWithCTRL(List<String> titles) {
    LOG.info("Select items " + titles + " on Display As Grid");
    utils.actions.selectItemByClickWithCTRL(displayAsGridItems, titles);
    return this;
  }

  public DemoqaSelectable selectSerializeFeedbackMoreItemsWithCTRL(List<String> titles) {
    LOG.info("Select items " + titles + " on Serialize Feedback");
    utils.actions.selectItemByClickWithCTRL(serializeFeedbackItems, titles);
    return this;
  }

}

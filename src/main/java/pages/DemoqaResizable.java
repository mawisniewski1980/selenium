package pages;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;
import utilsobjects.Draggable;


public class DemoqaResizable extends PageObject {


  public DemoqaResizable(WebDriver driver) {
    super(driver);
  }

  private final String xLineCss = ".ui-resizable-e";
  private final String yLineCss = ".ui-resizable-s";
  private final String xyLineCss = ".ui-resizable-se";

  private final String defaultFunctionalityResizableCss = "#resizable";
  @FindBy(css = defaultFunctionalityResizableCss)
  private WebElement defaultFunctionalityResizable;

  private final String animateResizableCss = "#resizableani";
  @FindBy(css = animateResizableCss)
  private WebElement animateResizable;

  private final String constrainResizableAreaContainerCss = "#container1";
  @FindBy(css = constrainResizableAreaContainerCss)
  private WebElement constrainResizableAreaContainer;

  private final String constrainResizableAreaContainerResizableConstrainCss = "#resizableconstrain";
  @FindBy(css = constrainResizableAreaContainerResizableConstrainCss)
  private WebElement constrainResizableAreaContainerResizableConstrain;

  private final String resizableHelperCss = "#resizable_helper";
  @FindBy(css = resizableHelperCss)
  private WebElement resizableHelper;

  private final String minMaxSizeCss = "#resizable_max_min";
  @FindBy(css = minMaxSizeCss)
  private WebElement minMaxSize;

  public Dimension getDefaultFunctionalityResizableDimension() {
    return new Draggable(defaultFunctionalityResizable).getRectangle().getDimension();
  }

  public Dimension getAnimateResizableDimension() {
    return new Draggable(animateResizable).getRectangle().getDimension();
  }

  public Dimension getConstrainResizableAreaContainerDimension() {
    return new Draggable(constrainResizableAreaContainer).getRectangle().getDimension();
  }

  public Dimension getConstrainResizableAreaContainerResizableConstrainDimension() {
    return new Draggable(constrainResizableAreaContainerResizableConstrain).getRectangle().getDimension();
  }

  public Dimension getResizableHelperDimension() {
    return new Draggable(resizableHelper).getRectangle().getDimension();
  }

  public Dimension getMinMaxSizeDimension() {
    return new Draggable(minMaxSize).getRectangle().getDimension();
  }

  public DemoqaResizable resizeDefaultFunctionalityByX(int xOffset) {
    utils.getActions().moveByX(new Draggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByY(int yOffset) {
    utils.getActions().moveByY(new Draggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByXY(int xOffset, int yOffset) {
    utils.getActions().moveByXY(new Draggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeAnimateByX(int xOffset) {
    Draggable obj = new Draggable(utils.findNextElementByCssSelector(animateResizable, xLineCss));
    utils.getActions().moveByX(obj, xOffset);
    utils.getWaits().waitUntilAnimationStop(obj);
    return this;
  }

  public DemoqaResizable resizeAnimateByY(int yOffset) {
    Draggable obj = new Draggable(utils.findNextElementByCssSelector(animateResizable, yLineCss));
    utils.getActions().moveByY(obj, yOffset);
    utils.getWaits().waitUntilAnimationStop(obj);
    return this;
  }

  public DemoqaResizable resizeAnimateByXY(int xOffset, int yOffset) {
    Draggable obj = new Draggable(utils.findNextElementByCssSelector(animateResizable, xyLineCss));
    utils.getActions().moveByXY(obj, xOffset, yOffset);
    utils.getWaits().waitUntilAnimationStop(obj);
    return this;
  }

  public DemoqaResizable resizeConstrainByX(int xOffset) {
    utils.getActions().moveByX(new Draggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByY(int yOffset) {
    utils.getActions().moveByY(new Draggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByXY(int xOffset, int yOffset) {
    utils.getActions().moveByXY(new Draggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByX(int xOffset) {
    utils.getActions().moveByX(new Draggable(utils.findNextElementByCssSelector(resizableHelper, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByY(int yOffset) {
    utils.getActions().moveByY(new Draggable(utils.findNextElementByCssSelector(resizableHelper, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByXY(int xOffset, int yOffset) {
    utils.getActions().moveByXY(new Draggable(utils.findNextElementByCssSelector(resizableHelper, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByX(int xOffset) {
    utils.getActions().moveByX(new Draggable(utils.findNextElementByCssSelector(minMaxSize, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByY(int yOffset) {
    utils.getActions().moveByY(new Draggable(utils.findNextElementByCssSelector(minMaxSize, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByXY(int xOffset, int yOffset) {
    utils.getActions().moveByXY(new Draggable(utils.findNextElementByCssSelector(minMaxSize, xyLineCss)), xOffset, yOffset);
    return this;
  }
}

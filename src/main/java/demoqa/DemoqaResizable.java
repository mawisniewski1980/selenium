package demoqa;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;
import utilsobjects.ODraggable;

public class DemoqaResizable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaResizable.class.getName());

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
    ODraggable obj = new ODraggable(defaultFunctionalityResizable);
    return obj.getDimension();
  }

  public Dimension getAnimateResizableDimension() {
    ODraggable obj = new ODraggable(animateResizable);
    return obj.getDimension();
  }

  public Dimension getConstrainResizableAreaContainerDimension() {
    ODraggable obj = new ODraggable(constrainResizableAreaContainer);
    return obj.getDimension();
  }

  public Dimension getConstrainResizableAreaContainerResizableConstrainDimension() {
    ODraggable obj = new ODraggable(constrainResizableAreaContainerResizableConstrain);
    return obj.getDimension();
  }

  public Dimension getResizableHelperDimension() {
    ODraggable obj = new ODraggable(resizableHelper);
    return obj.getDimension();
  }

  public Dimension getMinMaxSizeDimension() {
    ODraggable obj = new ODraggable(minMaxSize);
    return obj.getDimension();
  }

  public DemoqaResizable resizeDefaultFunctionalityByX(int xOffset) {
    utils.dragByX(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xLineCss), xOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByY(int yOffset) {
    utils.dragByY(utils.findNextElementByCssSelector(defaultFunctionalityResizable, yLineCss), yOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByXY(int xOffset, int yOffset) {
    utils.dragByXY(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xyLineCss), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeAnimateByX(int xOffset) {
    utils.dragByX(utils.findNextElementByCssSelector(animateResizable, xLineCss), xOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeAnimateByY(int yOffset) {
    utils.dragByY(utils.findNextElementByCssSelector(animateResizable, yLineCss), yOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeAnimateByXY(int xOffset, int yOffset) {
    utils.dragByXY(utils.findNextElementByCssSelector(animateResizable, xyLineCss), xOffset, yOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeConstrainByX(int xOffset) {
    utils.dragByX(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xLineCss), xOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByY(int yOffset) {
    utils.dragByY(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, yLineCss), yOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByXY(int xOffset, int yOffset) {
    utils.dragByXY(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xyLineCss), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByX(int xOffset) {
    utils.dragByX(utils.findNextElementByCssSelector(resizableHelper, xLineCss), xOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByY(int yOffset) {
    utils.dragByY(utils.findNextElementByCssSelector(resizableHelper, yLineCss), yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByXY(int xOffset, int yOffset) {
    utils.dragByXY(utils.findNextElementByCssSelector(resizableHelper, xyLineCss), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByX(int xOffset) {
    utils.dragByX(utils.findNextElementByCssSelector(minMaxSize, xLineCss), xOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByY(int yOffset) {
    utils.dragByY(utils.findNextElementByCssSelector(minMaxSize, yLineCss), yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByXY(int xOffset, int yOffset) {
    utils.dragByXY(utils.findNextElementByCssSelector(minMaxSize, xyLineCss), xOffset, yOffset);
    return this;
  }
}

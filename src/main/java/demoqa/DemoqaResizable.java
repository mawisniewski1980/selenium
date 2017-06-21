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
    return new ODraggable(defaultFunctionalityResizable).getRectangle().getDimension();
  }

  public Dimension getAnimateResizableDimension() {
    return new ODraggable(animateResizable).getRectangle().getDimension();
  }

  public Dimension getConstrainResizableAreaContainerDimension() {
    return new ODraggable(constrainResizableAreaContainer).getRectangle().getDimension();
  }

  public Dimension getConstrainResizableAreaContainerResizableConstrainDimension() {
    return new ODraggable(constrainResizableAreaContainerResizableConstrain).getRectangle().getDimension();
  }

  public Dimension getResizableHelperDimension() {
    return new ODraggable(resizableHelper).getRectangle().getDimension();
  }

  public Dimension getMinMaxSizeDimension() {
    return new ODraggable(minMaxSize).getRectangle().getDimension();
  }

  public DemoqaResizable resizeDefaultFunctionalityByX(int xOffset) {
    utils.moveByX(new ODraggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByY(int yOffset) {
    utils.moveByY(new ODraggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeDefaultFunctionalityByXY(int xOffset, int yOffset) {
    utils.moveByXY(new ODraggable(utils.findNextElementByCssSelector(defaultFunctionalityResizable, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeAnimateByX(int xOffset) {
    utils.moveByX(new ODraggable(utils.findNextElementByCssSelector(animateResizable, xLineCss)), xOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeAnimateByY(int yOffset) {
    utils.moveByY(new ODraggable(utils.findNextElementByCssSelector(animateResizable, yLineCss)), yOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeAnimateByXY(int xOffset, int yOffset) {
    utils.moveByXY(new ODraggable(utils.findNextElementByCssSelector(animateResizable, xyLineCss)), xOffset, yOffset);
    utils.waitUntilAnimationStop(animateResizable);
    return this;
  }

  public DemoqaResizable resizeConstrainByX(int xOffset) {
    utils.moveByX(new ODraggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByY(int yOffset) {
    utils.moveByY(new ODraggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeConstrainByXY(int xOffset, int yOffset) {
    utils.moveByXY(new ODraggable(utils.findNextElementByCssSelector(constrainResizableAreaContainerResizableConstrain, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByX(int xOffset) {
    utils.moveByX(new ODraggable(utils.findNextElementByCssSelector(resizableHelper, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByY(int yOffset) {
    utils.moveByY(new ODraggable(utils.findNextElementByCssSelector(resizableHelper, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeHelperByXY(int xOffset, int yOffset) {
    utils.moveByXY(new ODraggable(utils.findNextElementByCssSelector(resizableHelper, xyLineCss)), xOffset, yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByX(int xOffset) {
    utils.moveByX(new ODraggable(utils.findNextElementByCssSelector(minMaxSize, xLineCss)), xOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByY(int yOffset) {
    utils.moveByY(new ODraggable(utils.findNextElementByCssSelector(minMaxSize, yLineCss)), yOffset);
    return this;
  }

  public DemoqaResizable resizeMinMaxByXY(int xOffset, int yOffset) {
    utils.moveByXY(new ODraggable(utils.findNextElementByCssSelector(minMaxSize, xyLineCss)), xOffset, yOffset);
    return this;
  }
}

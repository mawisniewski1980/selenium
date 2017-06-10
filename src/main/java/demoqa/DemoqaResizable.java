package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaResizable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaResizable.class.getName());

  public DemoqaResizable(WebDriver driver) {
    super(driver);
  }

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

}

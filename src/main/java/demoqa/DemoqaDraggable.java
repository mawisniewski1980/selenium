package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobject.PageObject;

public class DemoqaDraggable extends PageObject {

  private static final Logger LOG = LoggerFactory.getLogger(DemoqaDraggable.class.getName());

  public DemoqaDraggable(WebDriver driver) {
    super(driver);
  }

  private final String defFuncDraggableCss = "#draggable";
  @FindBy(css = defFuncDraggableCss)
  private WebElement defFuncDraggable;

  private final String conMovVerticallyCss = "#draggable";
  @FindBy(css = conMovVerticallyCss)
  private WebElement conMovVertically;

  private final String conMovHorizontallyCss = "#draggable";
  @FindBy(css = conMovHorizontallyCss)
  private WebElement conMovHorizontally;

  private final String conWrapper1Css = "#containment-wrapper";
  @FindBy(css = conWrapper1Css)
  private WebElement conWrapper1;

  private final String conWrapper1BoxCss = "#draggabl3";
  @FindBy(css = conWrapper1BoxCss)
  private WebElement conWrapper1Box;

  private final String conWrapper2Css = "#containment-wrapper .draggable:not(#draggabl3)";
  @FindBy(css = conWrapper2Css)
  private WebElement conWrapper2;

  private final String conWrapper2BoxCss = "#draggabl5";
  @FindBy(css = conWrapper2BoxCss)
  private WebElement conWrapper2Box;

  private final String dragBox1Css = "#drag";
  @FindBy(css = dragBox1Css)
  private WebElement dragBox1;

  private final String dragBox2Css = "#drag2";
  @FindBy(css = dragBox2Css)
  private WebElement dragBox2;

  private final String dragBox3Css = "#drag3";
  @FindBy(css = dragBox3Css)
  private WebElement dragBox3;

  private final String drageventCss = "#dragevent";
  @FindBy(css = drageventCss)
  private WebElement dragevent;

  private final String draggableBoxCss = "#draggablebox";
  @FindBy(css = draggableBoxCss)
  private WebElement draggableBox;

  private final String sortableBoxUlCss = "ul#sortablebox";
  @FindBy(css = sortableBoxUlCss)
  private WebElement sortableBoxUl;

  private final String sortableBoxLiCss = "ul#sortablebox li";
  @FindBy(css = sortableBoxLiCss)
  private List<WebElement> sortableBoxLi;

}

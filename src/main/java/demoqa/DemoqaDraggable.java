package demoqa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.OPage;
import utilsobjects.ODraggable;

import java.util.List;



public class DemoqaDraggable extends OPage {

  private static final Logger LOG = LogManager.getLogger("DemoqaDraggable");

  public DemoqaDraggable(WebDriver driver) {
    super(driver);
  }

  private final String defFuncDraggableCss = "#draggable";
  @FindBy(css = defFuncDraggableCss)
  private WebElement defFuncDraggable;

  private final String conMovVerticallyCss = "#draggabl";
  @FindBy(css = conMovVerticallyCss)
  private WebElement conMovVertically;

  private final String conMovHorizontallyCss = "#draggabl2";
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

  public Point getPositionDefFuncDraggable() {
    return new ODraggable(defFuncDraggable).getRectangle().getPoint();
  }

  public Point getPositionConMovVertically() {
    return new ODraggable(conMovVertically).getRectangle().getPoint();
  }

  public Point getPositionConMovHorizontally() {
    return new ODraggable(conMovHorizontally).getRectangle().getPoint();
  }

  public Point getPositionConWrapper1Dimension() {
    return new ODraggable(conWrapper1).getRectangle().getPoint();
  }

  public Point getPositionConWrapper1Box() {
    return new ODraggable(conWrapper1Box).getRectangle().getPoint();
  }

  public Point getPositionConWrapper2() {
    return new ODraggable(conWrapper2).getRectangle().getPoint();
  }

  public Point getPositionConWrapper2Box() {
    return new ODraggable(conWrapper2Box).getRectangle().getPoint();
  }

  public Point getPositiondragCursorStyleBox1() {
    return new ODraggable(dragBox1).getRectangle().getPoint();
  }

  public Point getPositiondragCursorStyleBox2() {
    return new ODraggable(dragBox2).getRectangle().getPoint();
  }

  public Point getPositiondragCursorStyleBox3() {
    return new ODraggable(dragBox3).getRectangle().getPoint();
  }

  public DemoqaDraggable dragDefFuncDraggable(int xOffset, int yOffset) {
    utils.getActions().dragAndDropByOffset(new ODraggable(defFuncDraggable), xOffset, yOffset);
    return this;
  }

  public DemoqaDraggable dragConMovVertically(int xOffset, int yOffset) {
    utils.getActions().dragAndDropByOffset(new ODraggable(conMovVertically), xOffset, yOffset);
    return this;
  }

  public DemoqaDraggable dragConMovHorizontally(int xOffset, int yOffset) {
    utils.getActions().dragAndDropByOffset(new ODraggable(conMovHorizontally), xOffset, yOffset);
    return this;
  }

  public DemoqaDraggable dragConWrapper1Box(int xOffset, int yOffset) {
    utils.getActions().dragAndDropByOffset(new ODraggable(conWrapper1Box), xOffset, yOffset);
    return this;
  }
}

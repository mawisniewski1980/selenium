package utilsobjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class ODraggable {

  private WebElement element;

  public ODraggable(WebElement element) {
    this.element = element;
  }

  public WebElement getElement() {
    return element;
  }

  public Dimension getDimension() {
    Dimension dimension = element.getSize();
    return dimension;
  }

  public Point getPoint() {
    Point point = element.getLocation();
    return point;
  }

  public String getText() {
    return element.getText();
  }

  public int getWidth() {
    return getDimension().getWidth();
  }

  public int getHeight() {
    return getDimension().getHeight();
  }

  public int getHalfWidth() {
    return getDimension().getWidth() / 2;
  }

  public int getHalfHeight() {
    return getDimension().getHeight() / 2;
  }

  public int getX() {
    return getPoint().getX();
  }

  public int getY() {
    return getPoint().getY();
  }

  public OInSpace getPosition() {
    Point point = this.element.getLocation();
    Dimension dimension = this.element.getSize();

    Point leftTop = new Point(point.getX(), point.getY());
    Point rightTop = new Point(point.getX() + dimension.getWidth(), point.getY());
    Point leftDown = new Point(point.getX(), point.getY() + dimension.getHeight());
    Point rightDown = new Point(point.getX() + dimension.getWidth(), point.getY() + dimension.getHeight());

    return new OInSpace(leftTop, rightTop, leftDown, rightDown);
  }

  public Point getCenter() {
    return getCenterPointOfElement(element);
  }

  public Point getCenterSecondElement(WebElement element) {
    return getCenterPointOfElement(element);
  }

  public int getDistanceCenterToCenter(WebElement element) {
    double dx = getCenter().getX() - getCenterSecondElement(element).getX();
    double dy = getCenter().getY() - getCenterSecondElement(element).getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

  private Point getCenterPointOfElement(WebElement element) {
    Point point = element.getLocation();
    Dimension dimension = element.getSize();
    int x = point.getX() + dimension.getWidth() / 2;
    int y = point.getY() + dimension.getHeight() / 2;
    return new Point(x, y);
  }

}

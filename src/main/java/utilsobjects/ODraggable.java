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

  private Dimension getDimension() {
    Dimension dimension = element.getSize();
    return dimension;
  }

  private Point getPoint() {
    Point point = element.getLocation();
    return point;
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

  public ObjectInSpace getPosition() {
    Point point = element.getLocation();
    Dimension dimension = element.getSize();

    Point leftTop = new Point(point.getX(), point.getY());
    Point rightTop = new Point(point.getX() + dimension.getWidth(), point.getY());
    Point rightDown = new Point(point.getX() + dimension.getWidth(), point.getY() + dimension.getHeight());
    Point leftDown = new Point(point.getX(), point.getY() + dimension.getHeight());

    return new ObjectInSpace(leftTop, rightTop, rightDown, leftDown);
  }

  public Point getCenter() {
    Point point = element.getLocation();

    int x = point.getX() + getHalfWidth();
    int y = point.getY() + getHalfHeight();

    return new Point(x, y);
  }
}

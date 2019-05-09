package utils;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Draggable {

  private static final Logger LOG = LoggerFactory.getLogger(Draggable.class);

  private WebElement element;

  public Draggable(WebElement element) {
    this.element = element;
  }

  public WebElement getElement() {
    return element;
  }

  public Rectangle getRectangle() {
    Point point = element.getLocation();
    Dimension dimension = element.getSize();
    return new Rectangle(point, dimension);
  }

  public int getWidth() {
    return getRectangle().getWidth();
  }

  public int getHeight() {
    return getRectangle().getHeight();
  }

  public int getHalfWidth() {
    return getRectangle().getWidth() / 2;
  }

  public int getHalfHeight() {
    return getRectangle().getHeight() / 2;
  }

  public int getX() {
    return getRectangle().getX();
  }

  public int getY() {
    return getRectangle().getY();
  }

  public Point getCenter() {
    // logger.info("Center of the webelement");
    int x = getX() + getWidth() / 2;
    int y = getY() + getHeight() / 2;
    return new Point(x, y);
  }

  public int getThisDistanceBetweenCenterToCenterOther(Draggable drop) {
    double dx = this.getCenter().getX() - drop.getCenter().getX();
    double dy = this.getCenter().getY() - drop.getCenter().getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }
}

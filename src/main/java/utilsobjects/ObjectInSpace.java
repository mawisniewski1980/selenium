package utilsobjects;

import org.openqa.selenium.Point;

public class ObjectInSpace {

  private Point leftTop;
  private Point rightTop;
  private Point rightDown;
  private Point leftDown;

  public ObjectInSpace(Point leftTop, Point rightTop, Point rightDown, Point leftDown) {
    this.leftTop = leftTop;
    this.rightTop = rightTop;
    this.rightDown = rightDown;
    this.leftDown = leftDown;
  }

  public Point getLeftTop() {
    return leftTop;
  }

  public Point getRightTop() {
    return rightTop;
  }

  public Point getRightDown() {
    return rightDown;
  }

  public Point getLeftDown() {
    return leftDown;
  }

  @Override
  public String toString() {
    return "[leftTop=" + leftTop + ", rightTop=" + rightTop + ", rightDown=" + rightDown + ", leftDown=" + leftDown + "]";
  }
}

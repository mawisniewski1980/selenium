package utilsobjects;

import org.openqa.selenium.Point;

public class OInSpace {

  private Point leftTop;
  private Point rightTop;
  private Point leftDown;
  private Point rightDown;

  public OInSpace(Point leftTop, Point rightTop, Point leftDown, Point rightDown) {
    this.leftTop = leftTop;
    this.rightTop = rightTop;
    this.leftDown = leftDown;
    this.rightDown = rightDown;
  }

  public Point getLeftTop() {
    return leftTop;
  }

  public Point getRightTop() {
    return rightTop;
  }

  public Point getLeftDown() {
    return leftDown;
  }

  public Point getRightDown() {
    return rightDown;
  }

  @Override
  public String toString() {
    return "[leftTop=" + leftTop + ", rightTop=" + rightTop + ", leftDown=" + leftDown + ", rightDown=" + rightDown + "]";
  }
}

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

  public Point getCenter() {
    int x = (this.rightTop.getX() - this.leftTop.getX()) / 2;
    int y = (this.leftDown.getY() - this.leftTop.getY()) / 2;
    return new Point(x, y);
  }

  public void checkIfObjectIsInAnotherObject(OInSpace second) {

    System.out.println("Obj1 LT: " + getLeftTop());
    System.out.println("Obj1 RT: " + getRightTop());
    System.out.println("Obj1 LD: " + getLeftDown());
    System.out.println("Obj1 RD: " + getRightDown());

    System.out.println("Obj2 LT: " + second.getLeftTop());
    System.out.println("Obj2 RT: " + second.getRightTop());
    System.out.println("Obj2 LD: " + second.getLeftDown());
    System.out.println("Obj2 RD: " + second.getRightDown());
  }

  @Override
  public String toString() {
    return "[leftTop=" + leftTop + ", rightTop=" + rightTop + ", leftDown=" + leftDown + ", rightDown=" + rightDown + "]";
  }
}

package omnicomm.program;

public class Point {
  public double x;
  public double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  double getDistance(Point a) {
    return Math.sqrt( Math.pow(x-a.x, 2) + Math.pow(y-a.y, 2) );
  }
  double getRadius() {
    Point a = new Point(0,0);
    return this.getDistance(a);
  }
}

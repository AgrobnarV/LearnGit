package omnicomm.program;

public class Point {
  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p) {
    return this.x * this.y;
  }
}

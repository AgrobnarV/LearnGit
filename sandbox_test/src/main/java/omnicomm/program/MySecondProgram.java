package omnicomm.program;

public class MySecondProgram {

  public static void main(String[] args) {

    Point p1 = new Point(1, 1);
    Point p2 = new Point(10, 5);
    System.out.println("Точка с координатами " + p1.x + " " + p1.y + " и " + p2.x + " " + p2.y + " = " + p1.distance(p2));
  }
  public static double distance(Point p1, Point p2) {
    return distance(p1,p2);
  }
}
package omnicomm.program;

public class MySecondProgram {

  public static void main(String[] args) {

    Point a = new Point(25, 16);
    Point b = new Point(1, 15);
    System.out.println("Расстояние между точками: "+ b.getDistance(a));
  }
}
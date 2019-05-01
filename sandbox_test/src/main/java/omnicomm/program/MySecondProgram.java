package omnicomm.program;

public class MySecondProgram {

  public static void main(String[] args) {

    Point a = new Point(25, 16);
    Point b = new Point(1, 15);
    System.out.println("Расстояние между точками: "+ Math.round(b.getDistance(a) * 1000.0) / 1000.0);
  }
}
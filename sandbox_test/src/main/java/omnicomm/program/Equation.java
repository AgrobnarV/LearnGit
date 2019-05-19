package omnicomm.program;

public class Equation {
  private double a;
  private double b;
  private double c;

  private int num;

  public Equation (double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double disc = b*b - 4*a*c;

    if (a!=0) {
      if (disc > 0) {
        num = 2;
      } else  if (disc == 0) {
        num = 1;
      } else {
        num = 0;
      }

    } else  if (b!=0) {
      num = 1;

    } else  if (c!=0) {
      num = 0;

    } else {
      num = -1;
    }
    



  }
  public int rootNumber () {
    return num;
  }
}

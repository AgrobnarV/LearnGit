package omnicomm.program;

public class Rectangle { // класс Прямоугольник
  public double a; // длина прямоугльника
  public double b; // ширина прямоугльника

  public Rectangle (double a, double b) {
    this.a = a; // a заполняется значениями вручную
    this.b = b; // b заполняется значениями вручную
  }
  public double area () { // расчет площади из сторон прямоугольника
    return this.a * this.b; // формула расчета площади прямоугольника
  }
}

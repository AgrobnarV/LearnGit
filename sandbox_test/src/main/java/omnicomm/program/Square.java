package omnicomm.program;

public class Square { // класс Квадрат
  public double l; // сторона квадрата

  public Square (double l) { // конструктор
    this.l = l; // l заполняется значениями вручную

  }
  public double area () { // расчет площади из стороны квадрата
    return this.l * this.l; // формула расчета площади квадрата
  }
}

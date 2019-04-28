package omnicomm.program;

class Point {
  public double x1; // абсцисса точки 1
  public double y1; // ордината точки 1
  public double x2; // абсцисса точки 2
  public double y2; // ордината точки 2

  public Point(double x1, double y1, double x2, double y2) {
    this.x1 = x1; // x1 заполняется значениями вручную
    this.y1 = y1; // y1 заполняется значениями вручную
    this.x2 = x2; // x2 заполняется значениями вручную
    this.y2 = y2; // y2 заполняется значениями вручную
  }
  public double Distanse () { // вызываем формулу расстояния между двумя точками
    return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2)); // формула вычисления. разница точек x2, x1 возводится в степерь 2, также как и разница ординат. Оба значения складываются. Из суммы вычисляется квадратный корень
  }
}

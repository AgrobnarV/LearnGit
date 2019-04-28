package omnicomm.program;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Andrey"); // вызвать имя пользователя

    Square s = new Square(5); //вызов функкции квадрата
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s)); // считаем площадь квадрата по стороне

    Rectangle r = new Rectangle(4,6); // вызов функции прямоугольника
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r)); //считаем площадь прямоугольника по сторонам
  }
  public static void hello (String user) { // приветствие пользователя
    System.out.println("hello," + user + "."); // вывод строки приветствия
  }

  public static double area (Square s) { // расчет площади из стороны квадрата
    return s.l * s.l; // формула расчета площади квадрата
  }
  public static double area (Rectangle r) { // расчет площади из сторон прямоугольника
    return r.a * r.b; // формула расчета площади прямоугольника

  }
}
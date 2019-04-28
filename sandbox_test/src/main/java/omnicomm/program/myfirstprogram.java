package omnicomm.program;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Andrey"); // вызвать имя пользователя

    double l = 5.4; // сторона квадрата
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l)); // считаем площадь квадрата по стороне

    double a = 2; // длина прямоугольника
    double b = 3; // ширина прямоугольника
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b)); //считаем площадь прямоугольника по сторонам
  }
  public static void hello (String user) { // приветствие пользователя
    System.out.println("hello," + user + "."); // вывод строки приветствия
  }

  public static double area (double len) { // расчет площади из стороны квадрата
    return len * len; // формула расчета площади
  }
  public static double area (double a, double b) { // расчет площади из сторон прямоугольника
    return a * b; // формула расчета площади

  }
}
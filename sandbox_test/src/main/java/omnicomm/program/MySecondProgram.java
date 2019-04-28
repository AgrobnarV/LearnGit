package omnicomm.program;

public class MySecondProgram {

  public static void main(String[] args) {
    dz ("Задание №2: Потренироваться использовать функции, классы, объекты и методы");

    Point p1 = new Point(15,10,20,5); // ввод вручную значений координат
    System.out.println("Точка 1 с координатами " + p1.x1 + " и " + p1.y1); // вывод 1 точки
    System.out.println("Точка 2 с координатами " + p1.x2 + " и " + p1.y2); // вывод 2 точки
    System.out.println("Расстояние между точками = " + p1.Distanse ()); // вывод расстояния
    }

  public static void dz (String dz2) {
    System.out.println(dz2); // вывод строки с дз
  }  }
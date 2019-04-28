package omnicomm.program;

public class MyFirstProgram {

  public static void main(String[] args) {
    String hi = "Hello"; // переменная для hello
    String smb = "world"; // переменная для world
    System.out.println(hi + "," + smb + "!"); // выводим строку hello,world

    double l = 8; //значение стороны квадрата
    double s = l * l; //формула расчета площади
    System.out.println("Площадь квадрата со стороной " + l +  " = " + s); //считаем площадь квадрата по сторонам
  }

}
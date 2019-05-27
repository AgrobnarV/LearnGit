package omnicomm.program;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "Kotlin","C++","Python"};

    List<Integer> languages = Arrays.asList(1,2,3,4);

    for (Integer l : languages) {
      System.out.println("Новый язык " + l);
    }
  }
}

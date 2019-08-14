package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class RectangleTests {

  @Test
  public void TestArea() {

    Rectangle r = new Rectangle (4,6);
    assertEquals(r.area(),24.0);
  }
}

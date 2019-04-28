package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {

  @Test
  public void TestArea() {

    Rectangle r = new Rectangle (4,6);
    Assert.assertEquals(r.area(),25.0);
  }
}

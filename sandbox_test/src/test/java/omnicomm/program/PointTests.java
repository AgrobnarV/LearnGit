package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void TestMethod1() {
    Point p1 = new Point (1,2);
    Assert.assertEquals(p1.distance(p1),2.0);
  }
  @Test
  public void TestMethod2() {
    Point p2 = new Point (1,2);
    Assert.assertEquals(p2.distance(p2),2.0);
  }
}

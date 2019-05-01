package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void TestCommonPoint() {
    Point a = new Point (25,16);
    Point b = new Point (1,15);
    Assert.assertEquals(Math.round(b.getDistance(a)* 100.0 / 100.0),24);
  }
  @Test
  private void TestHighDiapozon() {
    Point a = new Point (1,999);
    Point b = new Point (999,0);
    Assert.assertEquals(Math.round(b.getDistance(a)* 100.0 / 100.0),1412);
  }
  @Test
  private void TestWithFirstNullPoint() {
    Point a = new Point (0,0);
    Point b = new Point (2,2);
    Assert.assertEquals(Math.round(b.getDistance(a)* 100.0 / 100.0),3);
  }
  @Test
  private void TestWithSecondNullPoint() {
    Point a = new Point (5,5);
    Point b = new Point (0,0);
    Assert.assertEquals(Math.round(b.getDistance(a)* 100.0 / 100.0),7);
  }
}

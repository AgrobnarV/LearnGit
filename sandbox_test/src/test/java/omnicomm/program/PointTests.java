package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.RoundingMode;

public class PointTests {
  @Test
  public void TestCommonPoint() {
    Point a = new Point(25, 16);
    Point b = new Point(1, 15);
    Assert.assertEquals(24.020824298928627, b.getDistance(a));
    //  Assert.assertEquals(b.getDistance(a),4);
  }
  @Test
  public void TestPointNotNull() {
    Point a = new Point (1,0);
    Point b = new Point (1,0);
    Assert.assertNotNull( b.getDistance(a));
  }
 @Test
  private void TestHighDiapozon() {
    Point a = new Point (1,0);
    Point b = new Point (1,0);
    Assert.assertTrue(b.getDistance(a) == 0.0);
    Assert.assertFalse(b.getDistance(a) == 1.5);
  }
  @Test
  private void TestWithFirstNullPoint() {
    Point a = new Point (0,0);
    Point b = new Point (2,2);
    Assert.assertEquals(b.getDistance(a),2.8284271247461903);
    Assert.assertTrue(Math.round(b.getDistance(a)) == 3.0);
    Assert.assertFalse(Math.round(b.getDistance(a)) == 2.82);
  }
  @Test
  private void TestWithSecondNullPoint() {
    Point a = new Point (5,5);
    Point b = new Point (0,0);
    Assert.assertEquals(b.getDistance(a),7.0710678118654755);
    Assert.assertTrue(Math.round(b.getDistance(a)) == 7.0);
    Assert.assertFalse(Math.round(b.getDistance(a)) == 7.1);
  }
}

package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void TestPointDistanse1() {
    Point p1 = new Point (1,1,1,1);
    Assert.assertEquals(p1.Distanse(),0.0);
  }
  @Test
  public void TestPointDistanse2() {
    Point p1 = new Point (1,2,4,8);
    Assert.assertEquals(p1.Distanse(),6.708203932499369);
  }
  @Test
  public void TestPointDistanse3() {
    Point p1 = new Point (-11,-22,33,44);
    Assert.assertEquals(p1.Distanse(),79.32212806020776);
  }
  @Test
  public void TestPointDistanse4() {
    Point p1 = new Point ( 0,255,0101,44);
    Assert.assertEquals(p1.Distanse(),220.78496325610584);
  }
}

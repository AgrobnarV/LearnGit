package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {
  @Test
  public void test0 () { //уравнения нет
    Equation e = new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);

  }
  @Test
  public void test1 () { //уравнения c 1 решением
    Equation e = new Equation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);

  }
  @Test
  public void test2 () { //уравнения с 2 решениями
    Equation e = new Equation(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);

  }
  @Test
  public void testLinear () { //уравнения линейное с 1 решением
    Equation e = new Equation(0,1,1);
    Assert.assertEquals(e.rootNumber(),1);

  }
  @Test
  public void testZero () { //уравнения 0=0
    Equation e = new Equation(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);

  }
  @Test
  public void testConstanta () { //уравнения с константой
    Equation e = new Equation(0,0,1);
    Assert.assertEquals(e.rootNumber(),0);

  }
}

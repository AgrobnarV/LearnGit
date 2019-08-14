package omnicomm.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PrimeTests {

  @Test
  public void testPrime () {
    assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testPrimeLong () {
    long n = Integer.MAX_VALUE;
    assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testPrimeFast () {
    assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime () {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}

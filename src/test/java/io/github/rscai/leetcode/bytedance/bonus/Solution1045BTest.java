package io.github.rscai.leetcode.bytedance.bonus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1045BTest {

  @Parameters(name = "{index}: sqrt of {0} is {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {8, 2},
        {125348, 354}
    });
  }

  private int x;
  private int sqrt;

  private Solution1045B testObject;

  public Solution1045BTest(int x, int sqrt) {
    this.x = x;
    this.sqrt = sqrt;
  }

  @Before
  public void setUp() {
    testObject = new Solution1045B();
  }

  @Test
  public void testMySqrt() {
    assertThat(testObject.mySqrt(x), is(sqrt));
  }
}

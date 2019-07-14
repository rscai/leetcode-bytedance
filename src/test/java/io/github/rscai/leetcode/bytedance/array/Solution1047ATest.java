package io.github.rscai.leetcode.bytedance.array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1047ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6}
    });
  }

  private int[] height;
  private int result;

  private Solution1047A testObject;

  public Solution1047ATest(int[] height, int result) {
    this.height = height;
    this.result = result;
  }

  @Before
  public void setUp() {
    testObject = new Solution1047A();
  }

  @Test
  public void testTrap() {
    assertThat(testObject.trap(height), is(result));
  }
}

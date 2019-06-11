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
public class Solution1036BTest {

  @Parameters(name = "{index}: {1} circles in M")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{
            new int[]{1, 1, 0},
            new int[]{1, 1, 0},
            new int[]{0, 0, 1}
        }, 2},
        {new int[][]{
            new int[]{1, 1, 0},
            new int[]{1, 1, 1},
            new int[]{0, 1, 1}
        }, 1}
    });
  }

  private int[][] m;
  private int circleNum;

  private Solution1036B testObject;

  public Solution1036BTest(int[][] m, int circleNum) {
    this.m = m;
    this.circleNum = circleNum;
  }

  @Before
  public void setUp() {
    testObject = new Solution1036B();
  }

  @Test
  public void testFindCircleNum() {
    assertThat(testObject.findCircleNum(m), is(circleNum));
  }
}


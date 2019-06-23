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
public class Solution1046BTest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{
            new int[]{1, 3},
            new int[]{2, 6},
            new int[]{8, 10},
            new int[]{15, 18}
        }, new int[][]{
            new int[]{1, 6},
            new int[]{8, 10},
            new int[]{15, 18}
        }},
        {new int[][]{
            new int[]{1, 4},
            new int[]{4, 5}
        }, new int[][]{
            new int[]{1, 5}
        }}
    });
  }

  private int[][] intervals;
  private int[][] result;
  private Solution1046B testObject;

  public Solution1046BTest(int[][] intervals, int[][] result) {
    this.intervals = intervals;
    this.result = result;
  }

  @Before
  public void setUp() {
    testObject = new Solution1046B();
  }

  @Test
  public void testMerge() {
    assertThat(testObject.merge(intervals), is(result));
  }
}

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
public class Solution1034BTest {

  @Parameters(name = "{index}: max area {1} from grid {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{
            new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }, 6},
        {new int[][]{
            new int[]{0, 0, 0, 0, 0, 0, 0, 0}
        }, 0}
    });
  }

  private int[][] grid;
  private int area;
  private Solution1034B testObject;

  public Solution1034BTest(int[][] grid, int area) {
    this.grid = grid;
    this.area = area;
  }

  @Before
  public void setUp() {
    testObject = new Solution1034B();
  }

  @Test
  public void testMaxAreaOfIsland() {
    assertThat(testObject.maxAreaOfIsland(grid), is(area));
  }
}

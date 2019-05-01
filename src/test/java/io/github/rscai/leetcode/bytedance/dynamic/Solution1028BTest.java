package io.github.rscai.leetcode.bytedance.dynamic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class Solution1028BTest {

  @Parameters(name = "{index}: max area {1} from matrix {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new char[][]{
            new char[]{'1', '0', '1', '0', '0'},
            new char[]{'1', '0', '1', '1', '1'},
            new char[]{'1', '1', '1', '1', '1'},
            new char[]{'1', '0', '0', '1', '0'}
        }, 4},
        {new char[][]{
            new char[]{'0', '0', '1', '0'},
            new char[]{'1', '1', '1', '1'},
            new char[]{'1', '1', '1', '1'},
            new char[]{'1', '1', '1', '0'},
            new char[]{'1', '1', '0', '0'},
            new char[]{'1', '1', '1', '1'},
            new char[]{'1', '1', '1', '0'}
        }, 9}
    });
  }

  private char[][] matrix;
  private int area;
  private Solution1028B testObject;

  public Solution1028BTest(char[][] matrix, int area) {
    this.matrix = matrix;
    this.area = area;
  }

  @Before
  public void setUp() {
    testObject = new Solution1028B();
  }

  @Test
  public void testMaxProfit() {
    assertThat(testObject.maximalSquare(matrix), is(area));
  }

}

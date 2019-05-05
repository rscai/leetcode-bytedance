package io.github.rscai.leetcode.bytedance.dynamic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class Solution1030BTest {

  @Parameters(name = "{index}: min path {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        ), 11}
    });
  }

  private List<List<Integer>> triangle;
  private int min;
  private Solution1030B testObject;

  public Solution1030BTest(List<List<Integer>> triangle, int min) {
    this.triangle = triangle;
    this.min = min;
  }

  @Before
  public void setUp() {
    testObject = new Solution1030B();
  }

  @Test
  public void testMaxSubArray() {
    assertThat(testObject.minimumTotal(triangle), is(min));
  }
}


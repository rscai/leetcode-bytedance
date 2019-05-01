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
public class Solution1029ATest {

  @Parameters(name = "{index}: max sum {1} from nums {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6}
    });
  }

  private int[] nums;
  private int max;
  private Solution1029A testObject;

  public Solution1029ATest(int[] nums, int max) {
    this.nums = nums;
    this.max = max;
  }

  @Before
  public void setUp() {
    testObject = new Solution1029A();
  }

  @Test
  public void testMaxSubArray() {
    assertThat(testObject.maxSubArray(nums), is(max));
  }
}

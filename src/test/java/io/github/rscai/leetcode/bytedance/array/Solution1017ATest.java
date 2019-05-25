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
public class Solution1017ATest {

  @Parameters(name = "{index}: position {2} of {1} in {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4},
        {new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1}
    });
  }

  private int[] nums;
  private int target;
  private int pos;
  private Solution1017A testObject;

  public Solution1017ATest(int[] nums, int target, int pos) {
    this.nums = nums;
    this.target = target;
    this.pos = pos;
  }

  @Before
  public void setUp() {
    testObject = new Solution1017A();
  }

  @Test
  public void testSearch() {
    assertThat(testObject.search(nums, target), is(pos));
  }
}

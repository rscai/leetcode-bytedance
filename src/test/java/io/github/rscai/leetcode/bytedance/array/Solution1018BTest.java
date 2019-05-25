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
public class Solution1018BTest {

  @Parameters(name = "{index}: {1}-th element of {0} is {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{3, 2, 1, 5, 6, 4}, 2, 5},
        {new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4}
    });
  }

  private int[] nums;
  private int k;
  private int value;
  private Solution1018B testObject;

  public Solution1018BTest(int[] nums, int k, int value) {
    this.nums = nums;
    this.k = k;
    this.value = value;
  }

  @Before
  public void setUp() {
    testObject = new Solution1018B();
  }

  @Test
  public void testFindKthLargest() {
    assertThat(testObject.findKthLargest(nums, k), is(value));
  }
}

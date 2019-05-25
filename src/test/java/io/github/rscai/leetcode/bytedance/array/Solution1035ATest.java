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
public class Solution1035ATest {

  @Parameters(name = "{index}: lengthOfLCIS {1} of {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{1, 3, 5, 4, 7}, 3},
        {new int[]{2, 2, 2, 2, 2}, 1}
    });
  }

  private int[] nums;
  private int length;
  private Solution1035A testObject;

  public Solution1035ATest(int[] nums, int length) {
    this.nums = nums;
    this.length = length;
  }

  @Before
  public void setUp() {
    testObject = new Solution1035A();
  }

  @Test
  public void testFindLengthOfLCIS() {
    assertThat(testObject.findLengthOfLCIS(nums), is(length));
  }
}

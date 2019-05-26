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
public class Solution1019BTest {

  @Parameters(name = "{index}: max consecutive length {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{100, 4, 200, 1, 3, 2}, 4}
    });
  }

  private int[] nums;
  private int length;

  private Solution1019B testObject;

  public Solution1019BTest(int[] nums, int length) {
    this.nums = nums;
    this.length = length;
  }

  @Before
  public void setUp() {
    testObject = new Solution1019B();
  }

  @Test
  public void testLongestConsecutive() {
    assertThat(testObject.longestConsecutive(nums), is(length));
  }
}

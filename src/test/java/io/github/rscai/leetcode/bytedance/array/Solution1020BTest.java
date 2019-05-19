package io.github.rscai.leetcode.bytedance.array;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Solution1020BTest {

  private Solution1020B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1020B();
  }

  @Test
  public void testThreeSum() {
    int[] input = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> actual = testObject.threeSum(input);
    assertThat(actual, hasSize(2));
    assertThat(actual.get(0), contains(-1, -1, 2));
    assertThat(actual.get(1), contains(-1, 0, 1));
  }
}
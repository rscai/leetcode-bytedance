package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1029A {

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int start = 0; start < nums.length; start++) {
      int accum = nums[start];
      if (accum > max) {
        max = accum;
      }
      for (int end = start + 1; end < nums.length; end++) {
        accum += nums[end];
        if (accum > max) {
          max = accum;
        }
      }
    }
    return max;
  }
}

package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1029B {

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int accum = 0;
    for (int index = 0; index < nums.length; index++) {
      accum += nums[index];
      if (accum > max) {
        max = accum;
      }
      if (accum < 0) {
        accum = 0;
      }
    }
    return max;
  }
}

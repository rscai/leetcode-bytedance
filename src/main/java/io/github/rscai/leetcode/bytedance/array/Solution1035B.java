package io.github.rscai.leetcode.bytedance.array;

public class Solution1035B {

  public int findLengthOfLCIS(int[] nums) {
    int max = 0;
    int length = 0;
    int previous = Integer.MIN_VALUE;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] > previous) {
        length++;
      } else {
        if (length > max) {
          max = length;
        }
        length = 1;
      }
      previous = nums[index];
    }
    if (length > max) {
      max = length;
    }
    return max;
  }
}

package io.github.rscai.leetcode.bytedance.array;

public class Solution1035A {

  public int findLengthOfLCIS(int[] nums) {
    int max = 0;
    for (int start = 0; start < nums.length; start++) {
      for (int end = start; end < nums.length; end++) {
        if (isAscending(nums, start, end) && end - start + 1 > max) {
          max = end - start + 1;
        }
      }
    }
    return max;
  }

  private boolean isAscending(int[] nums, int start, int end) {
    int previous = nums[start];
    for (int index = start + 1; index <= end; index++) {
      if (nums[index] <= previous) {
        return false;
      }
      previous = nums[index];
    }
    return true;
  }
}

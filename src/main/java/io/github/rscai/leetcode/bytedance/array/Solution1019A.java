package io.github.rscai.leetcode.bytedance.array;

import java.util.Arrays;

public class Solution1019A {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int max = 1;
    int length = 1;
    for (int index = 1; index < nums.length; index++) {
      if (nums[index] == nums[index - 1]) {
        continue;
      } else if (nums[index] - nums[index - 1] == 1) {
        length++;
      } else {
        if (length > max) {
          max = length;
        }
        length = 1;
      }
    }
    if (length > max) {
      max = length;
    }
    return max;
  }
}

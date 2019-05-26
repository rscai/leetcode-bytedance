package io.github.rscai.leetcode.bytedance.array;

import java.util.HashMap;
import java.util.Map;

public class Solution1019B {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> lengths = new HashMap<>(nums.length);
    int max = 1;
    for (int num : nums) {
      if (lengths.containsKey(num)) {
        continue;
      }
      int leftLength = lengths.getOrDefault(num - 1, 0);
      int rightLength = lengths.getOrDefault(num + 1, 0);
      int length = leftLength + rightLength + 1;
      if (length > max) {
        max = length;
      }
      lengths.put(num, length);
      lengths.put(num - leftLength, length);
      lengths.put(num + rightLength, length);
    }
    return max;
  }
}

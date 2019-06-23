package io.github.rscai.leetcode.bytedance.array;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1046B {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[][]{};
    }
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] left, int[] right) {
        if (left[0] < right[0]) {
          return -1;
        }
        if (left[0] > right[0]) {
          return 1;
        }
        return 0;
      }
    });
    int[][] result = new int[intervals.length][];
    int resultCount = 0;
    int[] current = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] <= current[1]) {
        current[0] = Math.min(current[0], interval[0]);
        current[1] = Math.max(current[1], interval[1]);
      } else {
        result[resultCount] = current;
        resultCount++;
        current = interval;
      }
    }
    result[resultCount] = current;
    resultCount++;
    return Arrays.copyOfRange(result, 0, resultCount);
  }
}

package io.github.rscai.leetcode.bytedance.array;

public class Solution1047A {

  public int trap(int[] height) {
    int area = 0;
    for (int index = 0; index < height.length; index++) {
      int regionalArea =
          Math.min(maxHeight(height, 0, index), maxHeight(height, index + 1, height.length))
              - height[index];
      if (regionalArea > 0) {
        area += regionalArea;
      }
    }
    return area;
  }

  private int maxHeight(int[] height, int start, int end) {
    int max = 0;
    for (int index = start; index < end; index++) {
      if (height[index] > max) {
        max = height[index];
      }
    }
    return max;
  }
}

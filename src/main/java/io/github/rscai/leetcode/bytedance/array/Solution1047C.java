package io.github.rscai.leetcode.bytedance.array;

public class Solution1047C {

  public int trap(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int area = 0;
    int leftMaxHeight = 0;
    int rightMaxHeight = 0;
    while (leftIndex < rightIndex) {
      if (height[leftIndex] < height[rightIndex]) {
        if (height[leftIndex] >= leftMaxHeight) {
          leftMaxHeight = height[leftIndex];
        } else {
          area += leftMaxHeight - height[leftIndex];
        }
        leftIndex++;
      } else {
        if (height[rightIndex] >= rightMaxHeight) {
          rightMaxHeight = height[rightIndex];
        } else {
          area += rightMaxHeight - height[rightIndex];
        }
        rightIndex--;
      }
    }
    return area;
  }
}

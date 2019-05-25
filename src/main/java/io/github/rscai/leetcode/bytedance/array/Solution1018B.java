package io.github.rscai.leetcode.bytedance.array;

public class Solution1018B {

  public int findKthLargest(int[] nums, int k) {
    return findKthLargest(nums, 0, nums.length, k);
  }

  // [start, end)
  private int findKthLargest(int[] nums, int start, int end, int k) {
    int pivotIndex = start;
    for (int index = start + 1; index < end; index++) {
      if (nums[index] < nums[pivotIndex]) {
        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[index];
        nums[index] = nums[pivotIndex + 1];
        nums[pivotIndex + 1] = pivot;
        pivotIndex = pivotIndex + 1;
      }
    }
    if (nums.length - pivotIndex == k) {
      return nums[pivotIndex];
    }
    if (nums.length - pivotIndex < k) {
      return findKthLargest(nums, start, pivotIndex, k);
    } else {
      return findKthLargest(nums, pivotIndex + 1, end, k);
    }
  }
}

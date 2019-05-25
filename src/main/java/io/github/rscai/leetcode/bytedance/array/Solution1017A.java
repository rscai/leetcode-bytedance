package io.github.rscai.leetcode.bytedance.array;

public class Solution1017A {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }
    return search(nums, start, end, target);
  }

  public int search(int[] nums, int start, int end, int target) {
    if (end - start <= 1) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[start] < nums[end] && target < nums[mid]) {
      return search(nums, start, mid, target);
    }
    if (nums[start] < nums[end] && nums[mid] < target) {
      return search(nums, mid, end, target);
    }
    if (nums[start] > nums[end] && nums[end] > nums[mid] && target > nums[mid]
        && target > nums[start]) {
      return search(nums, start, mid, target);
    }
    if (nums[start] > nums[end] && nums[end] > nums[mid] && target < nums[mid]) {
      return search(nums, start, mid, target);
    }
    if (nums[start] > nums[end] && nums[end] > nums[mid] && target > nums[mid]
        && target < nums[start]) {
      return search(nums, mid, end, target);
    }
    if (nums[mid] > nums[start] && nums[start] > nums[end] && nums[start] < target
        && target < nums[mid]) {
      return search(nums, start, mid, target);
    }
    if (nums[mid] > nums[start] && nums[start] > nums[end] && target < nums[mid]
        && target < nums[start]) {
      return search(nums, mid, end, target);
    }
    if (nums[mid] > nums[start] && nums[start] > nums[end] && target > nums[mid]) {
      return search(nums, mid, end, target);
    }
    return -1;
  }
}

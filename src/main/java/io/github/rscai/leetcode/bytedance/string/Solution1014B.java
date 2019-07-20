package io.github.rscai.leetcode.bytedance.string;

public class Solution1014B {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    return longestCommonPrefix(strs, 0, strs.length);
  }

  private String longestCommonPrefix(String[] strs, int start, int end) {
    if (end - start == 1) {
      return strs[start];
    }
    int mid = (end + start) / 2;
    String firstCommonPrefix = longestCommonPrefix(strs, start, mid);
    String secondCommonPrefix = longestCommonPrefix(strs, mid, end);

    return commonPrefix(firstCommonPrefix, secondCommonPrefix);
  }

  private String commonPrefix(String first, String second) {
    int minLength = Math.min(first.length(), second.length());
    for (int i = 0; i < minLength; i++) {
      if (first.charAt(i) != second.charAt(i)) {
        return first.substring(0, i);
      }
    }
    return first.substring(0, minLength);
  }
}

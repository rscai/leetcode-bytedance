package io.github.rscai.leetcode.bytedance.string;

public class Solution1014A {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (String str : strs) {
        if (str.length() <= i || ch != str.charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }
}

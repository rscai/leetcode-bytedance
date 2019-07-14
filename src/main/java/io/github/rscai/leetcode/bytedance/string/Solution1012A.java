package io.github.rscai.leetcode.bytedance.string;

import java.util.HashSet;
import java.util.Set;

public class Solution1012A {

  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    for (int start = 0; start < s.length(); start++) {
      for (int end = start + 1; end <= s.length(); end++) {
        if (isUnique(s.substring(start, end)) && (end - start) > maxLength) {
          maxLength = end - start;
        }
      }
    }
    return maxLength;
  }

  private boolean isUnique(String s) {
    Set<Character> containedChars = new HashSet<>();
    for (Character ch : s.toCharArray()) {
      if (containedChars.contains(ch)) {
        return false;
      }
      containedChars.add(ch);
    }
    return true;
  }
}

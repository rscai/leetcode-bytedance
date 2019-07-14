package io.github.rscai.leetcode.bytedance.string;

import java.util.HashSet;
import java.util.Set;

public class Solution1012C {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new HashSet<>();
    int maxLength = 0;
    int start = 0;
    int end = 0;
    while (start < s.length() && end < s.length()) {
      if (!charSet.contains(s.charAt(end))) {
        charSet.add(s.charAt(end));
        maxLength = Math.max(maxLength, end - start + 1);
        end++;
      } else {
        charSet.remove(s.charAt(start));
        start++;
      }
    }
    return maxLength;
  }
}

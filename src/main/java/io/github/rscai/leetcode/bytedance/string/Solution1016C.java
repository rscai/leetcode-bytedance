package io.github.rscai.leetcode.bytedance.string;

public class Solution1016C {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1LetterCounts = strToCounts(s1);
    for (int start = 0; start <= s2.length() - s1.length(); start++) {
      String sub = s2.substring(start, start + s1.length());
      int[] subLetterCounts = strToCounts(sub);
      if (isEqual(s1LetterCounts, subLetterCounts)) {
        return true;
      }
    }
    return false;
  }

  private int[] strToCounts(String str) {
    int[] counts = new int[26];
    for (int i = 0; i < str.length(); i++) {
      int index = Character.codePointAt(str, i) - 97;
      counts[index] = counts[index] + 1;
    }
    return counts;
  }

  private boolean isEqual(int[] a, int[] b) {
    if (a.length != b.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}

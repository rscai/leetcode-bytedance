package io.github.rscai.leetcode.bytedance.string;

public class Solution1016D {

  private static final int CHAR_CODE_OFFSET = 97;

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1LetterCounts = strToCounts(s1);
    String sub = s2.substring(0, s1.length());
    int[] subLetterCounts = strToCounts(sub);
    if (isEqual(s1LetterCounts, subLetterCounts)) {
      return true;
    }
    for (int start = 1; start <= s2.length() - s1.length(); start++) {
      char removedChar = s2.charAt(start - 1);
      char addedChar = s2.charAt(start + s1.length() - 1);
      subLetterCounts[removedChar - CHAR_CODE_OFFSET] =
          subLetterCounts[removedChar - CHAR_CODE_OFFSET] - 1;
      subLetterCounts[addedChar - CHAR_CODE_OFFSET] =
          subLetterCounts[addedChar - CHAR_CODE_OFFSET] + 1;
      if (isEqual(s1LetterCounts, subLetterCounts)) {
        return true;
      }
    }
    return false;
  }

  private int[] strToCounts(String str) {
    int[] counts = new int[26];
    for (int i = 0; i < str.length(); i++) {
      int index = Character.codePointAt(str, i) - CHAR_CODE_OFFSET;
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

package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1016B {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    Object[] result = permutation(s1, "", s2);
    return (Boolean) result[0];
  }

  Object[] permutation(String str, String accessed, String target) {
    if (str.length() == 0) {
      return new Object[]{true, Collections.singletonList("")};
    }
    List<String> permutations = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (target.contains(accessed + ch)) {
        Object[] remain = permutation(strMinusAtIndex(str, i), accessed + ch, target);
        boolean isNil = (Boolean) remain[0];
        if (isNil) {
          return new Object[]{true, Collections.emptyList()};
        }
        List<String> remainPermutations = (List<String>) remain[1];
        for (String remainPermutation : remainPermutations) {
          permutations.add(ch + remainPermutation);
        }
      }
    }
    return new Object[]{false, permutations};
  }

  private String strMinusAtIndex(String str, int index) {
    if (index < 0) {
      return str;
    }
    if (index >= str.length()) {
      return str;
    }
    if (index == str.length() - 1) {
      return str.substring(0, index);
    }
    return str.substring(0, index) + str.substring(index + 1, str.length());
  }
}

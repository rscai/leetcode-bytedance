package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1016A {

  public boolean checkInclusion(String s1, String s2) {
    if(s1.length()>s2.length()){
      return false;
    }
    for (String str : permutation(s1)) {
      if (s2.contains(str)) {
        return true;
      }
    }
    return false;
  }

  List<String> permutation(String str) {
    if (str.length() == 0) {
      return Collections.singletonList("");
    }
    List<String> permutations = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      for (String remain : permutation(strMinusAtIndex(str, i))) {
        permutations.add(ch + remain);
      }
    }
    return permutations;
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

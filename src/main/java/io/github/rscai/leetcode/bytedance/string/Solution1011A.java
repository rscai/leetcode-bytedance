package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.List;

public class Solution1011A {

  public String reverseWords(String s) {
    List<String> strings = splitBySpace(s);
    StringBuilder builder = new StringBuilder();
    for (int i = strings.size() - 1; i >= 0; i--) {
      if (builder.length() > 0) {
        builder.append(" ");
        builder.append(strings.get(i));
      } else {
        builder.append(strings.get(i));
      }
    }
    return builder.toString();
  }

  private List<String> splitBySpace(String input) {
    List<String> results = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    for (char ch : input.toCharArray()) {
      if (ch == ' ') {
        if (builder.length() > 0) {
          results.add(builder.toString());
          builder = new StringBuilder();
        }
      } else {
        builder.append(ch);
      }
    }
    if (builder.length() > 0) {
      results.add(builder.toString());
    }
    return results;
  }
}

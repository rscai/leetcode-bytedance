package io.github.rscai.leetcode.bytedance.array;

import java.util.LinkedList;
import java.util.List;

public class Solution1021A {

  public String getPermutation(int n, int k) {
    int[] indexes = new int[n];
    // 0-based index
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = ((k - 1) % factorial(n - i)) / factorial(n - 1 - i);
    }
    List<String> chars = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      chars.add(String.valueOf(i));
    }
    StringBuilder result = new StringBuilder();
    for (int index : indexes) {
      result.append(chars.get(index));
      chars.remove(index);
    }
    return result.toString();
  }

  private int factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}

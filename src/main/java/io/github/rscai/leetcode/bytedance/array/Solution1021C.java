package io.github.rscai.leetcode.bytedance.array;

import java.util.LinkedList;
import java.util.List;

public class Solution1021C {

  public String getPermutation(int n, int k) {
    int[] indexes = new int[n];
    // 0-based index
    int factN = 1;
    int factNMinusOne = 1;
    for (int i = indexes.length - 1; i >= 0; i--) {

      factN = (n - i) * factNMinusOne;
      indexes[i] = ((k - 1) % factN) / factNMinusOne;
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
}

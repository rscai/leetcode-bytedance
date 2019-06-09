package io.github.rscai.leetcode.bytedance.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Solution1021B {

  public String getPermutation(int n, int k) {
    Function<Integer, Integer> factorial = new Function<Integer, Integer>() {
      private Map<Integer, Integer> cachedSolutions = new HashMap<>();

      @Override
      public Integer apply(Integer n) {
        if (cachedSolutions.containsKey(n)) {
          return cachedSolutions.get(n);
        }
        Integer solution = doApply(n);
        cachedSolutions.put(n, solution);
        return solution;
      }

      private int doApply(int n) {
        if (n == 0) {
          return 1;
        }
        return n * apply(n - 1);
      }
    };
    int[] indexes = new int[n];
    // 0-based index
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = ((k - 1) % factorial.apply(n - i)) / factorial.apply(n - 1 - i);
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

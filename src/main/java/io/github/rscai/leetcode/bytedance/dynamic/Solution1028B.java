package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution1028B {

  public int maximalSquare(char[][] matrix) {
    BiFunction<Integer, Integer, Integer> maxSideLengthStartAt = new BiFunction<Integer, Integer, Integer>() {
      private Map<String, Integer> cache = new HashMap<>();

      @Override
      public Integer apply(Integer row, Integer col) {
        String key = String.format("%d-%d", row, col);
        if (cache.containsKey(key)) {
          return cache.get(key);
        }
        Integer result = doApply(row, col);
        cache.put(key, result);
        return result;
      }

      private Integer doApply(Integer row, Integer col) {
        if (row >= matrix.length || col >= matrix[row].length) {
          return 0;
        }
        if ('0' == matrix[row][col]) {
          return 0;
        }
        return 1 + Math
            .min(apply(row + 1, col + 1), 
                Math.min(apply(row + 1, col), 
                    apply(row, col + 1)));
      }
    };
    int maxSideLength = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        int sideLength = maxSideLengthStartAt.apply(row, col);
        if (sideLength > maxSideLength) {
          maxSideLength = sideLength;
        }
      }
    }
    return maxSideLength * maxSideLength;
  }

}

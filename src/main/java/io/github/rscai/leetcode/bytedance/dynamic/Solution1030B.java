package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution1030B {

  public int minimumTotal(List<List<Integer>> triangle) {
    BiFunction<Integer, Integer, Integer> minPathLength = new BiFunction<Integer, Integer, Integer>() {
      private Map<String, Integer> cache = new HashMap<>();

      @Override
      public Integer apply(Integer startIndex, Integer row) {
        final String key = String.format("%d-%d", startIndex, row);
        if (cache.containsKey(key)) {
          return cache.get(key);
        }
        Integer result = doApply(startIndex, row);
        cache.put(key, result);
        return result;
      }

      private Integer doApply(Integer startIndex, Integer row) {
        if (row >= triangle.size()) {
          return 0;
        }
        List<Integer> firstRow = triangle.get(row);
        List<Integer> firstElementIndexes = Arrays.asList(startIndex);
        if (firstRow.size() > startIndex + 1) {
          firstElementIndexes = Arrays.asList(startIndex, startIndex + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer firstElementIndex : firstElementIndexes) {
          int pathLength = firstRow.get(firstElementIndex) + apply(firstElementIndex, row + 1);
          if (pathLength < min) {
            min = pathLength;
          }
        }
        return min;
      }
    };
    return minPathLength.apply(0, 0);
  }
}

package io.github.rscai.leetcode.bytedance.array;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Solution1047B {

  public int trap(int[] height) {
    Function<Integer, Integer> maxHeightOnLeftSide = new Function<Integer, Integer>() {
      private Map<Integer, Integer> cached = new HashMap<>();

      @Override
      public Integer apply(Integer end) {
        if (cached.containsKey(end)) {
          return cached.get(end);
        }
        Integer result = doApply(end);
        cached.put(end, result);
        return result;
      }

      private Integer doApply(Integer end) {
        if (end == 0) {
          return 0;
        }
        if (end == 1) {
          return height[0];
        }
        return Math.max(apply(end - 1), height[end - 1]);
      }
    };

    Function<Integer, Integer> maxHeightOnRightSide = new Function<Integer, Integer>() {
      private Map<Integer, Integer> cached = new HashMap<>();

      @Override
      public Integer apply(Integer start) {
        if (cached.containsKey(start)) {
          return cached.get(start);
        }
        Integer result = doApply(start);
        cached.put(start, result);
        return result;
      }

      private Integer doApply(Integer start) {
        if (start >= height.length) {
          return 0;
        }
        if (start == height.length - 1) {
          return height[start];
        }
        return Math.max(apply(start + 1), height[start]);
      }
    };

    int area = 0;
    for (int index = 0; index < height.length; index++) {
      int regionalArea =
          Math.min(maxHeightOnLeftSide.apply(index), maxHeightOnRightSide.apply(index + 1))
              - height[index];
      if (regionalArea > 0) {
        area += regionalArea;
      }
    }
    return area;
  }

}

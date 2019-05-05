package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1030C {

  public int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> minPathLengths = new ArrayList<>();
    for (List<Integer> row : triangle) {
      minPathLengths.add(Collections.emptyList());
    }
    for (int rowIndex = triangle.size() - 1; rowIndex >= 0; rowIndex--) {
      List<Integer> row = triangle.get(rowIndex);
      List<Integer> minPathLength = new ArrayList<>();
      if (rowIndex >= triangle.size() - 1) {
        for (Integer value : row) {
          minPathLength.add(value);
        }
      } else {
        for (int indexOnRow = 0; indexOnRow < row.size(); indexOnRow++) {
          minPathLength.add(row.get(indexOnRow) + Math
              .min(minPathLengths.get(rowIndex + 1).get(indexOnRow),
                  minPathLengths.get(rowIndex + 1).get(indexOnRow + 1)));
        }
      }
      minPathLengths.set(rowIndex, minPathLength);
    }
    return minPathLengths.get(0).get(0);
  }
}

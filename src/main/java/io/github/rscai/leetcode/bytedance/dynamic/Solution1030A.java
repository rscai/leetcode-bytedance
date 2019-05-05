package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1030A {

  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> pathLengths = pathLengths(0, triangle);
    int min = Integer.MAX_VALUE;
    for (Integer pathLength : pathLengths) {
      if (pathLength < min) {
        min = pathLength;
      }
    }
    return min;

  }

  private List<Integer> pathLengths(int startIndex, List<List<Integer>> rows) {
    if (rows.size() == 0) {
      return Collections.singletonList(0);
    }
    List<Integer> firstRow = rows.get(0);
    List<List<Integer>> remainRows = rows.subList(1, rows.size());
    List<Integer> allPathLengths = new ArrayList<>();
    List<Integer> firstElementIndexes = Arrays.asList(startIndex);
    if (firstRow.size() > startIndex + 1) {
      firstElementIndexes = Arrays.asList(startIndex, startIndex + 1);
    }
    for (Integer firstElementIndex : firstElementIndexes) {
      for (Integer remainPathLength : pathLengths(firstElementIndex, remainRows)) {
        allPathLengths.add(firstRow.get(firstElementIndex) + remainPathLength);
      }
    }
    return allPathLengths;
  }
}

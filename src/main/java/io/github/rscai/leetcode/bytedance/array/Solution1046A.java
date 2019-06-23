package io.github.rscai.leetcode.bytedance.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1046A {

  public int[][] merge(int[][] intervals) {
    List<List<int[]>> components = new ArrayList<>();
    Set<int[]> globalAccessed = new HashSet<>();
    for (int[] start : intervals) {
      List<int[]> component = depthFirstSearch(intervals, start, new ArrayList<int[]>(),
          globalAccessed);
      if (component.size() > 0) {
        components.add(component);
      }
    }
    int[][] result = new int[components.size()][];
    int index = 0;
    for (List<int[]> component : components) {
      int start = Integer.MAX_VALUE;
      int end = Integer.MIN_VALUE;
      for (int[] interval : component) {
        start = Math.min(start, interval[0]);
        end = Math.max(end, interval[1]);
      }
      result[index] = new int[]{start, end};
      index++;
    }
    return result;
  }

  private List<int[]> depthFirstSearch(int[][] intervals, int[] start, List<int[]> accessed,
      Set<int[]> globalAccessed) {
    if (globalAccessed.contains(start)) {
      return accessed;
    }
    accessed.add(start);
    globalAccessed.add(start);
    int[] child = nextChild(intervals, start, globalAccessed);
    while (child != null) {
      depthFirstSearch(intervals, child, accessed, globalAccessed);
      child = nextChild(intervals, start, globalAccessed);
    }
    return accessed;
  }

  private int[] nextChild(int[][] intervals, int[] parent, Set<int[]> accessed) {
    for (int[] interval : intervals) {
      if (!accessed.contains(interval) && isOverlay(parent, interval)) {
        return interval;
      }
    }
    return null;
  }

  private boolean isOverlay(int[] one, int[] another) {
    if (Math.max(one[1], another[1]) - Math.min(one[0], another[0])
        <= one[1] - one[0] + another[1] - another[0]) {
      return true;
    }
    return false;
  }
}

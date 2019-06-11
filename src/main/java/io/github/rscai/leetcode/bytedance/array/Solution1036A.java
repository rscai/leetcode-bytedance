package io.github.rscai.leetcode.bytedance.array;

import java.util.HashSet;
import java.util.Set;

public class Solution1036A {

  public int findCircleNum(int[][] M) {
    Set<Set<Integer>> components = new HashSet<>();
    for (int start = 0; start < M.length; start++) {
      Set<Integer> component = depthFirstSearch(M, start, new HashSet<>());
      if (component.size() > 0) {
        components.add(component);
      }
    }
    return components.size();
  }

  private Set<Integer> depthFirstSearch(int[][] graph, int start, Set<Integer> accessed) {
    accessed.add(start);
    int child = nextChild(graph, start, accessed);
    while (child > -1) {
      accessed = depthFirstSearch(graph, child, accessed);
      child = nextChild(graph, start, accessed);
    }
    return accessed;
  }

  private int nextChild(int[][] graph, int parent, Set<Integer> accessed) {
    for (int another = 0; another < graph.length; another++) {
      if (graph[parent][another] == 1 && !accessed.contains(another)) {
        return another;
      }
    }
    return -1;
  }
}

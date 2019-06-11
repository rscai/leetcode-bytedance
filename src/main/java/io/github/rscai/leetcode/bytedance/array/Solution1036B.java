package io.github.rscai.leetcode.bytedance.array;

import java.util.HashSet;
import java.util.Set;

public class Solution1036B {

  public int findCircleNum(int[][] M) {
    int count = 0;
    for (int start = 0; start < M.length; start++) {
      Set<Integer> component = depthFirstSearch(M, start, new HashSet<>());
      if (component.size() > 0) {
        count++;
      }
    }
    return count;
  }

  private Set<Integer> depthFirstSearch(int[][] graph, int start, Set<Integer> accessed) {
    if (graph[start][start] == 0) {
      return accessed;
    }
    accessed.add(start);
    graph[start][start] = 0;
    int child = nextChild(graph, start, accessed);
    while (child > -1) {
      accessed = depthFirstSearch(graph, child, accessed);
      graph[start][child] = 0;
      graph[child][start] = 0;
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

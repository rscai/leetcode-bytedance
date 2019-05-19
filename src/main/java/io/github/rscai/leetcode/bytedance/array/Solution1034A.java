package io.github.rscai.leetcode.bytedance.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1034A {

  public int maxAreaOfIsland(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int maxArea = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        Set<Integer> accessed = new HashSet<>();
        int area = depthFirstTraversal(row, col, grid, accessed).size();
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }
    return maxArea;
  }

  private Set<Integer> depthFirstTraversal(int row, int col, int[][] grid, Set<Integer> accessed) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (grid[row][col] == 0) {
      return accessed;
    }
    accessed.add(row * cols + col);
    List<int[]> childrenPoints = children(grid, new int[]{row, col});
    for (int[] point : childrenPoints) {
      int address = point[0] * cols + point[1];
      if (!accessed.contains(address)) {
        accessed.add(address);
        accessed = depthFirstTraversal(point[0], point[1], grid, accessed);
      }
    }

    return accessed;
  }

  private List<int[]> children(int[][] grid, int[] parent) {
    int rows = grid.length;
    int cols = grid[0].length;
    List<int[]> children = new ArrayList<>();
    int row = parent[0];
    int col = parent[1];
    if (row - 1 >= 0 && grid[row - 1][col] == 1) {
      children.add(new int[]{row - 1, col});
    }
    if (row + 1 < rows && grid[row + 1][col] == 1) {
      children.add(new int[]{row + 1, col});
    }
    if (col - 1 >= 0 && grid[row][col - 1] == 1) {
      children.add(new int[]{row, col - 1});
    }
    if (col + 1 < cols && grid[row][col + 1] == 1) {
      children.add(new int[]{row, col + 1});
    }
    return children;
  }
}

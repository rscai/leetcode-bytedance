package io.github.rscai.leetcode.bytedance.array;

public class Solution1034B {

  public int maxAreaOfIsland(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int maxArea = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        int area = depthFirstTraversal(row, col, grid);
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }
    return maxArea;
  }

  private int depthFirstTraversal(int row, int col, int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (grid[row][col] == 0) {
      return 0;
    }
    int count = 1;
    grid[row][col] = -1;
    int[] child = oneChildren(grid, row, col);
    while (child != null) {
      grid[child[0]][child[1]] = -1;
      count = count + depthFirstTraversal(child[0], child[1], grid);
      child = oneChildren(grid, row, col);
    }

    return count;
  }

  private int[] oneChildren(int[][] grid, int row, int col) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (row - 1 >= 0 && grid[row - 1][col] == 1) {
      return new int[]{row - 1, col};
    }
    if (row + 1 < rows && grid[row + 1][col] == 1) {
      return new int[]{row + 1, col};
    }
    if (col - 1 >= 0 && grid[row][col - 1] == 1) {
      return new int[]{row, col - 1};
    }
    if (col + 1 < cols && grid[row][col + 1] == 1) {
      return new int[]{row, col + 1};
    }
    return null;
  }
}

package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1028C {

  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) {
      return 0;
    }
    int cols = matrix[0].length;
    if (cols == 0) {
      return 0;
    }
    int maxSideLength = 0;
    int[][] maxSideLengths = new int[rows][cols];
    for (int row = rows - 1; row >= 0; row--) {
      for (int col = cols - 1; col >= 0; col--) {
        if ('1' == matrix[row][col]) {
          int maxSideLengthOfRight = 0;
          int maxSideLengthOfDown = 0;
          int maxSideLengthOfRightDown = 0;
          if (col + 1 < cols) {
            maxSideLengthOfRight = maxSideLengths[row][col + 1];
          }
          if (row + 1 < rows) {
            maxSideLengthOfDown = maxSideLengths[row + 1][col];
          }
          if (col + 1 < cols && row + 1 < rows) {
            maxSideLengthOfRightDown = maxSideLengths[row + 1][col + 1];
          }
          int maxSideLengthAtCurrent = 1 + Math
              .min(maxSideLengthOfRight, Math.min(maxSideLengthOfDown, maxSideLengthOfRightDown));
          maxSideLengths[row][col] = maxSideLengthAtCurrent;
          if (maxSideLengthAtCurrent > maxSideLength) {
            maxSideLength = maxSideLengthAtCurrent;
          }
        }
      }
    }
    return maxSideLength * maxSideLength;
  }
}

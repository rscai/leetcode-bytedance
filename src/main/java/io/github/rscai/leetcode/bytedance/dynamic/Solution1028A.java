package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1028A {

  public int maximalSquare(char[][] matrix) {
    int maxSideLength = 0;
    for (int rowStart = 0; rowStart < matrix.length; rowStart++) {
      for (int rowEnd = rowStart + 1; rowEnd < matrix.length + 1; rowEnd++) {
        int sideLength = rowEnd - rowStart;
        for (int colStart = 0; colStart < matrix[rowStart].length - sideLength + 1; colStart++) {
          int colEnd = colStart + sideLength;
          if (isSquare(matrix, rowStart, rowEnd, colStart, colEnd)) {
            if (sideLength > maxSideLength) {
              maxSideLength = sideLength;
            }
          }
        }
      }
    }
    return maxSideLength * maxSideLength;
  }

  private boolean isSquare(char[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
    for (int row = rowStart; row < rowEnd; row++) {
      for (int col = colStart; col < colEnd; col++) {
        if (matrix[row][col] != '1') {
          return false;
        }
      }
    }
    return true;
  }
}

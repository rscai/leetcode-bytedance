package io.github.rscai.leetcode.bytedance.bonus;

public class Solution1045A {

  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    double xn = 0;
    double xn1 = x/2;
    while (Math.abs(xn1 - xn) > 1e-12) {
      xn = xn1;
      xn1 = (xn + (double) x / xn) / 2.0;
    }
    return (int) xn1;
  }
}

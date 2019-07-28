package io.github.rscai.leetcode.bytedance.bonus;

public class Solution1045B {

  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    int start = 1;
    int end = x;
    while (end - start != 1) {
      long mid = (end + start) / 2;
      if ((mid * mid) <= x) {
        start = (int) mid;
      } else {
        end = (int) mid;
      }
    }
    return start;
  }
}

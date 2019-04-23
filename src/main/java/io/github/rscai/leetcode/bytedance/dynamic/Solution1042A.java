package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1042A {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int buyAt = 0; buyAt < prices.length; buyAt++) {
      for (int sellAt = buyAt + 1; sellAt < prices.length; sellAt++) {
        int profit = prices[sellAt] - prices[buyAt];
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }
}

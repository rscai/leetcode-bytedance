package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1042B {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minBuyPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minBuyPrice) {
        minBuyPrice = prices[i];
      } else if (prices[i] - minBuyPrice > maxProfit) {
        maxProfit = prices[i] - minBuyPrice;
      }
    }
    return maxProfit;
  }
}

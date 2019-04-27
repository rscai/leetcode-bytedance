package io.github.rscai.leetcode.bytedance.dynamic;

public class Solution1043B {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int remainStart = 0;
    while (remainStart < prices.length) {
      int[] profitAndRemainStart = profit(prices, remainStart);
      maxProfit = maxProfit + profitAndRemainStart[0];
      remainStart = profitAndRemainStart[1];
    }
    return maxProfit;
  }

  private int[] profit(int[] prices, int start) {
    int profit = 0;
    for (int sellAt = start + 1; sellAt < prices.length; sellAt++) {
      if (prices[sellAt] - prices[sellAt - 1] < 0) {
        return new int[]{profit, sellAt};
      } else {
        profit = profit + prices[sellAt] - prices[sellAt - 1];
      }
    }
    return new int[]{profit, prices.length};
  }
}

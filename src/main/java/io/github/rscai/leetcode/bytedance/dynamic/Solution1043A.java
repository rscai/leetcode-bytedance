package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution1043A {

  public int maxProfit(int[] prices) {
    Stream<IntStream> allProfitSeqs = profitSeqs(prices, 0);

    return allProfitSeqs.map(profitSeq -> profitSeq.sum()).mapToInt(Integer::valueOf).max()
        .orElse(0);

  }

  private Stream<IntStream> profitSeqs(int[] prices, int start) {
    if (start >= prices.length) {
      return Stream.of(IntStream.empty());
    }
    Stream<IntStream> profitSeqs = Stream.empty();
    int buyAt = start;
    for (int sellAt = buyAt; sellAt < prices.length; sellAt++) {
      int profit = prices[sellAt] - prices[buyAt];
      Stream<IntStream> remainProfitSeqs = profitSeqs(prices, sellAt + 1);
      profitSeqs = Stream.concat(profitSeqs, remainProfitSeqs
          .map(remainProfitSeq -> IntStream.concat(IntStream.of(profit), remainProfitSeq)));
    }
    
    return profitSeqs;
  }
}

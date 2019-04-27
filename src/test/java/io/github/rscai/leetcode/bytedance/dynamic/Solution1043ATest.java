package io.github.rscai.leetcode.bytedance.dynamic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1043ATest {

  @Parameters(name = "{index}: max profit {1} from prices {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{7, 1, 5, 3, 6, 4}, 7},
        {new int[]{1, 2, 3, 4, 5}, 4},
        {new int[]{7, 6, 4, 3, 1}, 0}
    });
  }

  private int[] prices;
  private int profit;
  private Solution1043A testObject;

  public Solution1043ATest(int[] prices, int profit) {
    this.prices = prices;
    this.profit = profit;
  }

  @Before
  public void setUp() {
    testObject = new Solution1043A();
  }

  @Test
  public void testMaxProfit() {
    assertThat(testObject.maxProfit(prices), is(profit));
  }
}

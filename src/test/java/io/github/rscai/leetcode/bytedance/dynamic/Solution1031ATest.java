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
public class Solution1031ATest {

  @Parameters(name = "{index}: max {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{
            new int[]{5, 4}, 
            new int[]{6, 4}, 
            new int[]{6, 7}, 
            new int[]{2, 3}
        }, 3}
    });
  }

  private int[][] envelopes;
  private int max;
  private Solution1031A testObject;

  public Solution1031ATest(int[][] envelopes, int max) {
    this.envelopes = envelopes;
    this.max = max;
  }

  @Before
  public void setUp() {
    testObject = new Solution1031A();
  }

  @Test
  public void testMaxSubArray() {
    assertThat(testObject.maxEnvelopes(envelopes), is(max));
  }
}




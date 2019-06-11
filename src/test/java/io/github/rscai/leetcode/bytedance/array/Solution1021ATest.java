package io.github.rscai.leetcode.bytedance.array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1021ATest {

  @Parameters(name = "{index}: {1}-th permutation in {0} elements is {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {3, 3, "213"},
        {4, 9, "2314"}
    });
  }

  private int n;
  private int k;
  private String permutation;

  private Solution1021A testObject;

  public Solution1021ATest(int n, int k, String permutation) {
    this.n = n;
    this.k = k;
    this.permutation = permutation;
  }

  @Before
  public void setUp() {
    testObject = new Solution1021A();
  }

  @Test
  public void testGetPermutation() {
    assertThat(testObject.getPermutation(n, k), is(permutation));
  }
}

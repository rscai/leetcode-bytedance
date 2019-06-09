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
public class Solution1021CTest {

  @Parameters(name = "{index}: {1}-th permutation in {0} elements is {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {3, 5, "312"}
    });
  }

  private int n;
  private int k;
  private String permutation;

  private Solution1021C testObject;

  public Solution1021CTest(int n, int k, String permutation) {
    this.n = n;
    this.k = k;
    this.permutation = permutation;
  }

  @Before
  public void setUp() {
    testObject = new Solution1021C();
  }

  @Test
  public void testGetPermutation() {
    assertThat(testObject.getPermutation(n, k), is(permutation));
  }
}

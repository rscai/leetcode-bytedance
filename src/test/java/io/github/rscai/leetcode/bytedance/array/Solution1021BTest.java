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
public class Solution1021BTest {

  @Parameters(name = "{index}: {1}-th permutation in {0} elements is {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {3, 5, "312"}
    });
  }

  private int n;
  private int k;
  private String permutation;

  private Solution1021B testObject;

  public Solution1021BTest(int n, int k, String permutation) {
    this.n = n;
    this.k = k;
    this.permutation = permutation;
  }

  @Before
  public void setUp() {
    testObject = new Solution1021B();
  }

  @Test
  public void testGetPermutation() {
    assertThat(testObject.getPermutation(n, k), is(permutation));
  }
}

package io.github.rscai.leetcode.bytedance.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1012CTest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"abcabcbb", 3},
        {"bbbbb", 1},
        {"pwwkew", 3}
    });
  }

  private String s;
  private int maxLength;

  private Solution1012C testObject;

  public Solution1012CTest(String s, int maxLength) {
    this.s = s;
    this.maxLength = maxLength;
  }

  @Before
  public void setUp() {
    testObject = new Solution1012C();
  }

  @Test
  public void testTrap() {
    assertThat(testObject.lengthOfLongestSubstring(s), is(maxLength));
  }
}


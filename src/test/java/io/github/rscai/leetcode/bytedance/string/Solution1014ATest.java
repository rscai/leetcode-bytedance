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
public class Solution1014ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new String[]{"flower", "flow", "flight"}, "fl"},
        {new String[]{"dog", "racecar", "car"}, ""}
    });
  }

  private String[] strs;
  private String prefix;

  private Solution1014A testObject;

  public Solution1014ATest(String[] strs, String prefix) {
    this.strs = strs;
    this.prefix = prefix;
  }

  @Before
  public void setUp() {
    testObject = new Solution1014A();
  }

  @Test
  public void testTrap() {
    assertThat(testObject.longestCommonPrefix(strs), is(prefix));
  }
}

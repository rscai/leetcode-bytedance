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
public class Solution1016ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"ab", "eidbaooo", true},
        {"ab", "eidboaoo", false}
    });
  }

  private String s1;
  private String s2;
  private boolean isInclusion;

  private Solution1016A testObject;

  public Solution1016ATest(String s1, String s2, boolean isInclusion) {
    this.s1 = s1;
    this.s2 = s2;
    this.isInclusion = isInclusion;
  }

  @Before
  public void setUp() {
    testObject = new Solution1016A();
  }

  @Test
  public void testCheckInclusion() {
    assertThat(testObject.checkInclusion(s1, s2), is(isInclusion));
  }
}

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
public class Solution1011ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {" hello world!", "world! hello"},
        {" a good example  ", "example good a"}
    });
  }

  private String s;
  private String result;

  private Solution1011A testObject;

  public Solution1011ATest(String s, String result) {
    this.s = s;
    this.result = result;
  }

  @Before
  public void setUp() {
    testObject = new Solution1011A();
  }

  @Test
  public void testReverseWords() {
    assertThat(testObject.reverseWords(s), is(result));
  }
}

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
public class Solution1015ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"0", "0", "0"},
        {"2", "3", "6"},
        {"123", "456", "56088"}
    });
  }

  private String num1;
  private String num2;
  private String result;

  private Solution1015A testObject;

  public Solution1015ATest(String num1, String num2, String result) {
    this.num1 = num1;
    this.num2 = num2;
    this.result = result;
  }

  @Before
  public void setUp() {
    testObject = new Solution1015A();
  }

  @Test
  public void testMultiply() {
    assertThat(testObject.multiply(num1, num2), is(result));
  }

}

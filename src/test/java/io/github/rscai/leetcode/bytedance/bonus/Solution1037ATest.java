package io.github.rscai.leetcode.bytedance.bonus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1037ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{197, 139, 1}, true},
        {new int[]{235, 140, 4}, false}
    });
  }

  private int[] data;
  private boolean isValided;

  private Solution1037A testObject;

  public Solution1037ATest(int[] data, boolean isValided) {
    this.data = data;
    this.isValided = isValided;
  }

  @Before
  public void setUp() {
    testObject = new Solution1037A();
  }

  @Test
  public void testValidUtf8() {
    assertThat(testObject.validUtf8(data), is(isValided));
  }
}

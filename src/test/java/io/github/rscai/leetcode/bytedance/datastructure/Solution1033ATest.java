package io.github.rscai.leetcode.bytedance.datastructure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1033ATest {

  private Solution1033A testObject;

  @Before
  public void setUp() {
    testObject = new Solution1033A();
  }

  @Test
  public void testAllOne() {
    final String keyA = "A";
    final String keyB = "B";
    final String keyC = "C";
    testObject.inc(keyA);
    testObject.inc(keyB);
    testObject.inc(keyC);
    testObject.inc(keyB);
    assertThat(testObject.getMaxKey(), is(keyB));
    testObject.dec(keyA);
    testObject.inc(keyC);
    testObject.inc(keyC);
    assertThat(testObject.getMinKey(), is(keyB));
  }
}

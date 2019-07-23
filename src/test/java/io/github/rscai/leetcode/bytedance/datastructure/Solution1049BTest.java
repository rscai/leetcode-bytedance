package io.github.rscai.leetcode.bytedance.datastructure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1049BTest {

  private Solution1049B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1049B();
  }

  @Test
  public void testMinStack() {
    testObject.push(-2);
    testObject.push(0);
    testObject.push(-3);
    assertThat(testObject.getMin(), is(-3));
    testObject.pop();
    assertThat(testObject.top(), is(0));
    assertThat(testObject.getMin(), is(-2));
  }
}

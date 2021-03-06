package io.github.rscai.leetcode.bytedance.datastructure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Solution1032ATest {

  private Solution1032A testObject;

  @Test
  public void testLRUCache() {
    testObject = new Solution1032A(2);
    testObject.put(1, 1);
    testObject.put(2, 2);
    assertThat(testObject.get(1), is(1));
    testObject.put(3, 3);
    assertThat(testObject.get(2), is(Solution1032A.NOT_FOUND));
    testObject.put(4, 4);
    assertThat(testObject.get(1), is(Solution1032A.NOT_FOUND));
    assertThat(testObject.get(3), is(3));
    assertThat(testObject.get(4), is(4));
  }
}

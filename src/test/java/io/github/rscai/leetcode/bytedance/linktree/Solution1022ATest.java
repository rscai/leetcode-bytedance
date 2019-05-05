package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class Solution1022ATest {

  private Solution1022A testObject;

  @Before
  public void setUp() {
    testObject = new Solution1022A();
  }

  @Test
  public void testAddTowNumbers() {
    ListNode la = ListNode.buildFrom(Arrays.asList(2, 4, 3));
    ListNode lb = ListNode.buildFrom(Arrays.asList(5, 6, 4));

    ListNode actual = testObject.addTwoNumbers(la, lb);
    assertThat(ListNode.toList(actual), contains(7, 0, 8));
  }
}

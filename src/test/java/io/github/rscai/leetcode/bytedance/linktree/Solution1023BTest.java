package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1023BTest {

  private Solution1023B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1023B();
  }

  @Test
  public void testDetectCycle() {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    head.next = second;
    ListNode third = new ListNode(3);
    second.next = third;
    ListNode fourth = new ListNode(4);
    third.next = fourth;
    fourth.next = second;

    ListNode actual = testObject.detectCycle(head);
    assertThat(actual.val, is(2));
  }
}

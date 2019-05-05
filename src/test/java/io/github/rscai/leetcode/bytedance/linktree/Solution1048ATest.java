package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class Solution1048ATest {

  private Solution1048A testObject;

  @Before
  public void setUp() {
    testObject = new Solution1048A();
  }

  @Test
  public void testMergeTowList() {
    ListNode l1 = new ListNode(1);
    ListNode l1b = new ListNode(2);
    ListNode l1c = new ListNode(4);
    l1.next = l1b;
    l1b.next = l1c;

    ListNode l2 = new ListNode(1);
    ListNode l2b = new ListNode(3);
    ListNode l2c = new ListNode(4);
    l2.next = l2b;
    l2b.next = l2c;

    ListNode actual = testObject.mergeTwoLists(l1, l2);
    assertThat(actual.val, is(1));
    assertThat(actual.next.val, is(1));
    assertThat(actual.next.next.val, is(2));
    assertThat(actual.next.next.next.val, is(3));
    assertThat(actual.next.next.next.next.val, is(4));
    assertThat(actual.next.next.next.next.next.val, is(4));
  }
}
package io.github.rscai.leetcode.bytedance.linktree;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1024BTest {

  private Solution1024B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1024B();
  }

  @Test
  public void testGetIntersectionNode() {
    ListNode headA = new ListNode(4);
    ListNode secondA = new ListNode(1);

    ListNode headB = new ListNode(5);
    ListNode secondB = new ListNode(0);
    ListNode thirdB = new ListNode(1);

    ListNode firstC = new ListNode(8);
    ListNode secondC = new ListNode(4);
    ListNode thirdC = new ListNode(6);

    headA.next = secondA;
    secondA.next = firstC;

    headB.next = secondB;
    secondB.next = thirdB;
    thirdB.next = firstC;

    firstC.next = secondC;
    secondC.next = thirdC;

    ListNode actual = testObject.getIntersectionNode(headA, headB);
    assertThat(actual, is(firstC));
  }
}

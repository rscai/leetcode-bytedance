package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1038B {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode[] reversedHeadAndTail = reverseListRecursive(head);
    return reversedHeadAndTail[0];
  }

  private ListNode[] reverseListRecursive(ListNode head) {
    if (head.next == null) {
      return new ListNode[]{head, head};
    }
    ListNode first = head;
    ListNode[] remainReversedHeadAndTail = reverseListRecursive(head.next);
    ListNode reversedHead = remainReversedHeadAndTail[0];
    ListNode remainReversedTail = remainReversedHeadAndTail[1];
    first.next = null;
    remainReversedTail.next = first;
    return new ListNode[]{reversedHead, first};
  }
}

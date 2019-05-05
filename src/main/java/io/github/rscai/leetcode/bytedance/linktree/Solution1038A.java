package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1038A {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode previous = head;
    ListNode current = previous.next;
    previous.next = null;

    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }
}

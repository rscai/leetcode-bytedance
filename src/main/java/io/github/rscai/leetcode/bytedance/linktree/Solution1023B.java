package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1023B {

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode v = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        v = fast;
        break;
      }
    }
    if (v == null) {
      return null;
    }
    while (head != v) {
      head = head.next;
      v = v.next;
    }
    return v;
  }
}

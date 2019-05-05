package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1022A {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode la = l1;
    ListNode lb = l2;
    int carry = 0;
    ListNode head = null;
    ListNode tail = null;
    while (la != null || lb != null) {
      int aValue = 0;
      if (la != null) {
        aValue = la.val;
        la = la.next;
      }
      int bValue = 0;
      if (lb != null) {
        bValue = lb.val;
        lb = lb.next;
      }
      int sum = aValue + bValue + carry;
      carry = Math.floorDiv(sum, 10);
      ListNode newNode = new ListNode(sum % 10);
      if (tail == null) {
        head = newNode;
        tail = head;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }
    if (carry != 0) {
      ListNode newNode = new ListNode(carry);
      if (tail == null) {
        head = newNode;
        tail = head;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }
    return head;
  }
}

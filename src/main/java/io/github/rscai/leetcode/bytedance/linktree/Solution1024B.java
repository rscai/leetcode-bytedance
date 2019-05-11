package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1024B {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = length(headA);
    int lengthB = length(headB);
    ListNode currentA = headA;
    ListNode currentB = headB;
    if (lengthA > lengthB) {
      for (int i = 0; i < lengthA - lengthB; i++) {
        currentA = currentA.next;
      }
    } else {
      for (int i = 0; i < lengthB - lengthA; i++) {
        currentB = currentB.next;
      }
    }
    while (currentA != null && currentB != null) {
      if (currentA == currentB) {
        return currentA;
      }
      currentA = currentA.next;
      currentB = currentB.next;
    }
    return null;
  }

  private int length(ListNode head) {
    int len = 0;
    ListNode current = head;
    while (current != null) {
      len++;
      current = current.next;
    }
    return len;
  }
}

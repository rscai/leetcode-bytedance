package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1048A {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode la = l1;
    ListNode lb = l2;
    ListNode head = null;
    ListNode currentNode = head;
    while (la != null || lb != null) {
      if (la == null) {
        ListNode newNode = new ListNode(lb.val);
        lb = lb.next;
        currentNode = addTo(currentNode, newNode);
      } else if (lb == null) {
        ListNode newNode = new ListNode(la.val);
        la = la.next;
        currentNode = addTo(currentNode, newNode);
      } else if (la.val < lb.val) {
        ListNode newNode = new ListNode(la.val);
        la = la.next;
        currentNode = addTo(currentNode, newNode);
      } else {
        ListNode newNode = new ListNode(lb.val);
        lb = lb.next;
        currentNode = addTo(currentNode, newNode);
      }
      if (head == null) {
        head = currentNode;
      }
    }
    return head;
  }

  private ListNode addTo(ListNode currentNode, ListNode newNode) {
    if (currentNode == null) {
      return newNode;
    }
    currentNode.next = newNode;
    return newNode;
  }
}

package io.github.rscai.leetcode.bytedance.linktree;

/**
 * Quick sort
 */
public class Solution1040B {

  public ListNode sortList(ListNode head) {
    return quickSort(head);
  }

  private ListNode quickSort(ListNode head) {
    if (head == null) {
      return head;
    }
    if (head.next == null) {
      return head;
    }
    ListNode[] lists = divide(head);
    ListNode first = lists[0];
    ListNode pivot = lists[1];
    ListNode second = lists[2];
    ListNode sortedFirst = quickSort(first);
    ListNode sortedSecond = quickSort(second);
    ListNode sortedHead = sortedFirst;

    ListNode sortedTail = sortedHead;
    while (sortedTail != null && sortedTail.next != null) {
      sortedTail = sortedTail.next;
    }
    if (sortedTail != null) {
      sortedTail.next = pivot;
    } else {
      sortedHead = pivot;
      sortedTail = pivot;
    }
    pivot.next = sortedSecond;
    return sortedHead;
  }

  private ListNode[] divide(ListNode head) {
    ListNode pivot = head;
    ListNode firstHead = null;
    ListNode firstTail = firstHead;
    ListNode secondHead = null;
    ListNode secondTail = secondHead;
    ListNode current = head.next;
    pivot.next = null;
    while (current != null) {
      ListNode next = current.next;
      current.next = null;
      if (current.val < pivot.val) {
        if (firstTail == null) {
          firstTail = current;
          firstHead = firstTail;
        } else {
          firstTail.next = current;
          firstTail = firstTail.next;
        }
      } else {
        if (secondTail == null) {
          secondTail = current;
          secondHead = secondTail;
        } else {
          secondTail.next = current;
          secondTail = secondTail.next;
        }
      }
      current = next;
    }
    return new ListNode[]{firstHead, pivot, secondHead};
  }
}

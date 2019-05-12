package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1025B {

  public ListNode mergeKLists(ListNode[] lists) {
    return mergeKLists(lists, 0);
  }

  private ListNode mergeKLists(ListNode[] lists, int start) {
    if (start == lists.length) {
      return null;
    }
    if (start == lists.length - 1) {
      return lists[start];
    }
    ListNode first = lists[start];
    ListNode second = lists[start + 1];
    ListNode merged = merge(first, second);
    lists[start + 1] = merged;
    return mergeKLists(lists, start + 1);
  }

  private ListNode merge(ListNode firstHead, ListNode secondHead) {
    ListNode mergedHead = null;
    ListNode mergedTail = null;
    ListNode firstCurrent = firstHead;
    ListNode secondCurrent = secondHead;
    while (firstCurrent != null || secondCurrent != null) {
      if (firstCurrent == null) {
        ListNode secondNext = secondCurrent.next;
        secondCurrent.next = null;
        ListNode[] headAndTail = append(mergedHead, mergedTail, secondCurrent);
        mergedHead = headAndTail[0];
        mergedTail = headAndTail[1];
        secondCurrent = secondNext;
      } else if (secondCurrent == null) {
        ListNode firstNext = firstCurrent.next;
        firstCurrent.next = null;
        ListNode[] headAndTail = append(mergedHead, mergedTail, firstCurrent);
        mergedHead = headAndTail[0];
        mergedTail = headAndTail[1];
        firstCurrent = firstNext;
      } else if (firstCurrent.val < secondCurrent.val) {
        ListNode firstNext = firstCurrent.next;
        firstCurrent.next = null;
        ListNode[] headAndTail = append(mergedHead, mergedTail, firstCurrent);
        mergedHead = headAndTail[0];
        mergedTail = headAndTail[1];
        firstCurrent = firstNext;
      } else {
        ListNode secondNext = secondCurrent.next;
        secondCurrent.next = null;
        ListNode[] headAndTail = append(mergedHead, mergedTail, secondCurrent);
        mergedHead = headAndTail[0];
        mergedTail = headAndTail[1];
        secondCurrent = secondNext;
      }
    }
    return mergedHead;
  }

  private ListNode[] append(ListNode head, ListNode tail, ListNode node) {
    if (tail == null) {
      head = node;
      tail = head;
    } else {
      tail.next = node;
      tail = node;
    }
    return new ListNode[]{head, tail};
  }
}

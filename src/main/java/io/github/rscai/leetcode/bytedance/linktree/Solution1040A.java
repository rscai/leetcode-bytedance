package io.github.rscai.leetcode.bytedance.linktree;

/**
 * Merge sort
 */
public class Solution1040A {

  public ListNode sortList(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    return mergeSort(head, length);
  }

  private ListNode mergeSort(ListNode head, int length) {
    if (length == 0) {
      return head;
    }
    if (length == 1) {
      return head;
    }
    Object[] headLengths = binarySplit(head, length);
    ListNode firstHead = (ListNode) headLengths[0];
    int firstLength = (Integer) headLengths[1];
    ListNode secondHead = (ListNode) headLengths[2];
    int secondLength = (Integer) headLengths[3];
    ListNode sortedFirst = mergeSort(firstHead, firstLength);
    ListNode sortedSecond = mergeSort(secondHead, secondLength);
    return merge(sortedFirst, sortedSecond);
  }

  private Object[] binarySplit(ListNode head, int length) {
    int firstLength = Math.round(length / 2.0F);
    int secondLength = length - firstLength;
    ListNode secondHead = head;
    ListNode firstTail = head;
    for (int i = 0; i < firstLength; i++) {
      firstTail = secondHead;
      secondHead = secondHead.next;
    }
    firstTail.next = null;
    return new Object[]{head, firstLength, secondHead, secondLength};
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

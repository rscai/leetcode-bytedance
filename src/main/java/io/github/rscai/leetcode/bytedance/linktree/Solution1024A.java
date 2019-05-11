package io.github.rscai.leetcode.bytedance.linktree;

import java.util.HashSet;
import java.util.Set;

public class Solution1024A {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> accessed = new HashSet<>();
    ListNode currentA = headA;
    while (currentA != null) {
      accessed.add(currentA);
      currentA = currentA.next;
    }
    ListNode currentB = headB;
    while (currentB != null) {
      if (accessed.contains(currentB)) {
        return currentB;
      }
      currentB = currentB.next;
    }
    return null;
  }
}

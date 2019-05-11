package io.github.rscai.leetcode.bytedance.linktree;

import java.util.HashSet;
import java.util.Set;

public class Solution1023A {

  public ListNode detectCycle(ListNode head) {
    Set<ListNode> accessed = new HashSet<>();
    ListNode current = head;
    while (current != null) {
      if (accessed.contains(current)) {
        return current;
      }
      accessed.add(current);
      current = current.next;
    }
    return null;
  }
}

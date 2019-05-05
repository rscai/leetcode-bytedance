package io.github.rscai.leetcode.bytedance.linktree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListNode {

  static ListNode buildFrom(List<Integer> nums) {
    if (nums.size() == 1) {
      return new ListNode(nums.get(0));
    }
    ListNode head = new ListNode(nums.get(0));
    head.next = buildFrom(nums.subList(1, nums.size()));
    return head;
  }

  static List<Integer> toList(ListNode link) {
    if (link == null) {
      return Collections.emptyList();
    }
    List<Integer> list = new ArrayList<>();
    list.add(link.val);
    list.addAll(toList(link.next));
    return list;
  }

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

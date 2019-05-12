package io.github.rscai.leetcode.bytedance.linktree;

import java.util.LinkedList;
import java.util.List;

public class Solution1027B {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    return zigzagLevelOrder(root, 0);
  }

  private List<List<Integer>> zigzagLevelOrder(TreeNode root, int degree) {
    if (root == null) {
      return new LinkedList<>();
    }
    List<List<Integer>> left = zigzagLevelOrder(root.left, degree + 1);
    List<List<Integer>> right = zigzagLevelOrder(root.right, degree + 1);
    List<Integer> rootLevel = new LinkedList<>();
    rootLevel.add(root.val);
    List<List<Integer>> allLevels = new LinkedList<>();
    allLevels.add(rootLevel);
    for (int i = 0; i < Math.max(left.size(), right.size()); i++) {
      List<Integer> leftRow = new LinkedList<>();
      List<Integer> rightRow = new LinkedList<>();
      if (i < left.size()) {
        leftRow = left.get(i);
      }
      if (i < right.size()) {
        rightRow = right.get(i);
      }
      if ((degree + i + 1) % 2 == 0) {
        allLevels.add(merge(leftRow, rightRow));
      } else {
        allLevels.add(merge(rightRow, leftRow));
      }
    }
    return allLevels;
  }

  private List<Integer> merge(List<Integer> first, List<Integer> second) {
    first.addAll(second);
    return first;
  }
}

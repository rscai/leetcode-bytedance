package io.github.rscai.leetcode.bytedance.linktree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1027A {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    return zigzagLevelOrder(root, 0);
  }

  private List<List<Integer>> zigzagLevelOrder(TreeNode root, int degree) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> left = zigzagLevelOrder(root.left, degree + 1);
    List<List<Integer>> right = zigzagLevelOrder(root.right, degree + 1);
    List<Integer> rootLevel = Collections.singletonList(root.val);
    List<List<Integer>> allLevels = new ArrayList<>();
    allLevels.add(rootLevel);
    for (int i = 0; i < Math.max(left.size(), right.size()); i++) {
      List<Integer> leftRow = Collections.emptyList();
      List<Integer> rightRow = Collections.emptyList();
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
    List<Integer> result = new ArrayList<>(first.size() + second.size());
    result.addAll(first);
    result.addAll(second);
    return result;
  }
}

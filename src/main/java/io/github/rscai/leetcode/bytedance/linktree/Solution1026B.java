package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1026B {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val == p.val) {
      return p;
    }
    if (root.val == q.val) {
      return q;
    }

    TreeNode ancestorNodeOnLeft = lowestCommonAncestor(root.left, p, q);
    if (ancestorNodeOnLeft != null && ancestorNodeOnLeft.val != p.val
        && ancestorNodeOnLeft.val != q.val) {
      return ancestorNodeOnLeft;
    }
    TreeNode ancestorNodeOnRight = lowestCommonAncestor(root.right, p, q);
    if (ancestorNodeOnRight != null && ancestorNodeOnRight.val != p.val
        && ancestorNodeOnRight.val != q.val) {
      return ancestorNodeOnRight;
    }
    if (ancestorNodeOnLeft != null && ancestorNodeOnRight != null) {
      return root;
    }
    if (ancestorNodeOnLeft != null) {
      return ancestorNodeOnLeft;
    }
    if (ancestorNodeOnRight != null) {
      return ancestorNodeOnRight;
    }
    return null;
  }
}


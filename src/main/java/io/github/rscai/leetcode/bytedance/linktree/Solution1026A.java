package io.github.rscai.leetcode.bytedance.linktree;

public class Solution1026A {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    TreeNode ancestorNodeOnLeft = lowestCommonAncestor(root.left, p, q);
    if (ancestorNodeOnLeft != null) {
      return ancestorNodeOnLeft;
    }
    TreeNode ancestorNodeOnRight = lowestCommonAncestor(root.right, p, q);
    if (ancestorNodeOnRight != null) {
      return ancestorNodeOnRight;
    }

    if (isAncestorOf(root, p) && isAncestorOf(root, q)) {
      return root;
    }
    return null;
  }

  private boolean isAncestorOf(TreeNode node, TreeNode another) {
    if (node == null) {
      return false;
    }
    if (node.val == another.val) {
      return true;
    }
    if (isAncestorOf(node.left, another) || isAncestorOf(node.right, another)) {
      return true;
    }
    return false;
  }
}

package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1026BTest {

  private Solution1026B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1026B();
  }

  @Test
  public void testLowestCommonAncestor() {
    TreeNode root = new TreeNode(3);
    TreeNode a = new TreeNode(5);
    TreeNode b = new TreeNode(1);
    root.left = a;
    root.right = b;

    TreeNode aa = new TreeNode(6);
    TreeNode ab = new TreeNode(2);
    a.left = aa;
    a.right = ab;

    TreeNode ba = new TreeNode(0);
    TreeNode bb = new TreeNode(8);
    b.left = ba;
    b.right = bb;

    TreeNode p = new TreeNode(5);
    TreeNode q = new TreeNode(1);

    TreeNode actual = testObject.lowestCommonAncestor(root, p, q);
    assertThat(actual.val, is(3));
  }
}


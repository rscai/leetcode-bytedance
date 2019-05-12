package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Solution1027BTest {

  private Solution1027B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1027B();
  }

  @Test
  public void testZigzagLevelOrder() {
    TreeNode root = new TreeNode(3);
    TreeNode a = new TreeNode(9);
    TreeNode b = new TreeNode(20);
    root.left = a;
    root.right = b;
    TreeNode ba = new TreeNode(15);
    TreeNode bb = new TreeNode(7);
    b.left = ba;
    b.right = bb;

    List<List<Integer>> actual = testObject.zigzagLevelOrder(root);
    assertThat(actual, hasSize(3));
    assertThat(actual.get(0), contains(3));
    assertThat(actual.get(1), contains(20, 9));
    assertThat(actual.get(2), contains(15, 7));
  }
}

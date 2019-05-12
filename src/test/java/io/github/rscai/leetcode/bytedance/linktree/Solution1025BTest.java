package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class Solution1025BTest {

  private Solution1025B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1025B();
  }

  @Test
  public void testMergeKLists() {
    ListNode[] input = new ListNode[]{
        ListNode.buildFrom(Arrays.asList(1, 4, 5)),
        ListNode.buildFrom(Arrays.asList(1, 3, 4)),
        ListNode.buildFrom(Arrays.asList(2, 6))
    };
    ListNode actual = testObject.mergeKLists(input);
    assertThat(ListNode.toList(actual), contains(1, 1, 2, 3, 4, 4, 5, 6));
  }
}
package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class Solution1038BTest {

  private Solution1038B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1038B();
  }

  @Test
  public void testReverseList() {
    ListNode l = ListNode.buildFrom(Arrays.asList(1, 2, 3, 4, 5));
    ListNode actual = testObject.reverseList(l);
    assertThat(ListNode.toList(actual), contains(5, 4, 3, 2, 1));
  }
}

package io.github.rscai.leetcode.bytedance.linktree;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class Solution1040ATest {

  private Solution1040A testObject;

  @Before
  public void setUp() {
    testObject = new Solution1040A();
  }

  @Test
  public void testSortList() {
    ListNode l = ListNode.buildFrom(Arrays.asList(-1, 5, 3, 4, 0));
    ListNode actual = testObject.sortList(l);
    assertThat(ListNode.toList(actual), contains(-1, 0, 3, 4, 5));

  }
}

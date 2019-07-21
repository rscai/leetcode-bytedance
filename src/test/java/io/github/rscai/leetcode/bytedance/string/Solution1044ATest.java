package io.github.rscai.leetcode.bytedance.string;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1044ATest {

  private Solution1044A testObject;

  @Before
  public void setUp() {
    testObject = new Solution1044A();
  }

  @Test
  public void testRestoreIpAddresses() {
    assertThat(testObject.restoreIpAddresses("25525511135"),
        contains("255.255.11.135", "255.255.111.35"));
  }
}

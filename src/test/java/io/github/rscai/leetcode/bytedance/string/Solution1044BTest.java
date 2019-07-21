package io.github.rscai.leetcode.bytedance.string;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Solution1044BTest {

  private Solution1044B testObject;

  @Before
  public void setUp() {
    testObject = new Solution1044B();
  }

  @Test
  public void testRestoreIpAddresses() {
    assertThat(testObject.restoreIpAddresses("25525511135"),
        contains("255.255.11.135", "255.255.111.35"));
    assertThat(testObject.restoreIpAddresses("0000"),
        contains("0.0.0.0"));
    assertThat(testObject.restoreIpAddresses("010010"),
        contains("0.10.0.10", "0.100.1.0"));
  }
}

package io.github.rscai.leetcode.bytedance.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Solution1013ATest {

  @Parameters(name = "{index}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"/home/", "/home"},
        {"/../", "/"},
        {"/home//foo/", "/home/foo"},
        {"/a/./b/../../c/", "/c"},
        {"/a/../../b/../c//.//", "/c"},
        {"/a//b////c/d//././/..", "/a/b/c"}
    });
  }

  private String path;
  private String result;

  private Solution1013A testObject;

  public Solution1013ATest(String path, String result) {
    this.path = path;
    this.result = result;
  }

  @Before
  public void setUp() {
    testObject = new Solution1013A();
  }

  @Test
  public void testSimplifyPath() {
    assertThat(testObject.simplifyPath(path), is(result));
  }
}

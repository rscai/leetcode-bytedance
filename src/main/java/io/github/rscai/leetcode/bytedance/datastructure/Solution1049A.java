package io.github.rscai.leetcode.bytedance.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Solution1049A {

  private List<Integer> stack;

  /**
   * initialize your data structure here.
   */
  public Solution1049A() {
    stack = new ArrayList<>();
  }

  public void push(int x) {
    int currentMin = Integer.MAX_VALUE;
    if (stack.size() > 0) {
      currentMin = stack.get(stack.size() - 1);
    }
    stack.add(x);
    if (x < currentMin) {
      stack.add(x);
    } else {
      stack.add(currentMin);
    }
  }

  public void pop() {
    if (stack.size() > 0) {
      stack.remove(stack.size() - 1);
      stack.remove(stack.size() - 1);
    }
  }

  public int top() {
    if (stack.size() > 0) {
      return stack.get(stack.size() - 2);
    } else {
      return Integer.MIN_VALUE;
    }
  }

  public int getMin() {
    if (stack.size() > 0) {
      return stack.get(stack.size() - 1);
    } else {
      return Integer.MIN_VALUE;
    }
  }
}

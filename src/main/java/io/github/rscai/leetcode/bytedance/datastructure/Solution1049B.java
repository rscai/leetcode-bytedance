package io.github.rscai.leetcode.bytedance.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Solution1049B {

  private List<Integer> dataStack;
  private List<Integer> minValueStack;

  /**
   * initialize your data structure here.
   */
  public Solution1049B() {
    dataStack = new ArrayList<>();
    minValueStack = new ArrayList<>();
  }

  public void push(int x) {
    int currentMin = Integer.MAX_VALUE;
    if (minValueStack.size() > 0) {
      currentMin = minValueStack.get(minValueStack.size() - 1);
    }
    dataStack.add(x);
    if (x <= currentMin) {
      minValueStack.add(x);
    }
  }

  public void pop() {
    if (dataStack.size() > 0) {
      int dataValue = dataStack.remove(dataStack.size() - 1);
      if (dataValue == minValueStack.get(minValueStack.size() - 1)) {
        minValueStack.remove(minValueStack.size() - 1);
      }
    }
  }

  public int top() {
    if (dataStack.size() > 0) {
      return dataStack.get(dataStack.size() - 1);
    } else {
      return Integer.MIN_VALUE;
    }
  }

  public int getMin() {
    if (minValueStack.size() > 0) {
      return minValueStack.get(minValueStack.size() - 1);
    } else {
      return Integer.MIN_VALUE;
    }
  }
}

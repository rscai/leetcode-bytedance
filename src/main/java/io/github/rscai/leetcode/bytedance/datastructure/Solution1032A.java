package io.github.rscai.leetcode.bytedance.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1032A {

  public static final int NOT_FOUND = -1;
  private int capacity;
  private int usedCapacity;
  private Map<Integer, Integer> data;
  private List<Integer> recentUsed;

  public Solution1032A(int capacity) {
    this.capacity = capacity;
    data = new HashMap<>();
    recentUsed = new LinkedList<>();
  }

  public int get(int key) {
    if (data.containsKey(key)) {
      moveToRecentUsedHead(key);
      return data.get(key);
    } else {
      return NOT_FOUND;
    }
  }

  public void put(int key, int value) {
    if (null == data.put(key, value)) {
      usedCapacity++;
    }
    moveToRecentUsedHead(key);
    dropIfNeed();
  }

  private void moveToRecentUsedHead(int key) {
    recentUsed.remove(Integer.valueOf(key));
    recentUsed.add(0, key);
  }

  private void dropIfNeed() {
    if (usedCapacity > capacity) {
      int droppedKey = recentUsed.remove(recentUsed.size() - 1);
      data.remove(droppedKey);
      usedCapacity--;
    }
  }
}

package io.github.rscai.leetcode.bytedance.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Solution1032B {

  private class Node {

    int key;
    int value;
    Node previous;
    Node next;

    public Node() {

    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

  }

  public static final int NOT_FOUND = -1;
  private int capacity;
  private int usedCapacity;
  private Map<Integer, Node> data;
  private Node head;
  private Node tail;

  public Solution1032B(int capacity) {
    this.capacity = capacity;
    data = new HashMap<>();
  }

  public int get(int key) {
    if (data.containsKey(key)) {
      Node dataNode = data.get(key);
      moveToRecentUsedHead(dataNode);
      return dataNode.value;
    } else {
      return NOT_FOUND;
    }
  }

  public void put(int key, int value) {
    if (data.containsKey(key)) {
      Node dataNode = data.get(key);
      dataNode.value = value;
      moveToRecentUsedHead(dataNode);
    } else {
      Node dataNode = new Node(key, value);
      data.put(key, dataNode);
      usedCapacity++;
      moveToRecentUsedHead(dataNode);
      dropIfNeed();
    }
  }

  private void moveToRecentUsedHead(Node node) {
    if (head == node) {
      return;
    }
    // remove node from link
    removeFromLink(node);
    // add node to head
    if (head == null) {
      head = node;
      tail = node;
    } else {
      head.previous = node;
      node.next = head;
      head = node;
    }
  }

  private void dropIfNeed() {
    if (usedCapacity > capacity) {
      int droppedKey = tail.key;
      data.remove(droppedKey);
      // remove node from link
      removeFromLink(tail);
      usedCapacity--;
    }
  }

  private void removeFromLink(Node node) {
    Node previousNode = node.previous;
    Node nextNode = node.next;
    if (previousNode != null) {
      previousNode.next = node.next;
    }
    if (nextNode != null) {
      nextNode.previous = previousNode;
    }
    if (tail == node) {
      tail = previousNode;
    }
    if (head == node) {
      head = nextNode;
    }
  }
}

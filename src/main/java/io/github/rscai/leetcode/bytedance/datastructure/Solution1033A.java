package io.github.rscai.leetcode.bytedance.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Solution1033A {

  private class Node {

    String value;
    int count;
    Node previous;
    Node next;

    public Node() {

    }

    public Node(String value) {
      this.value = value;
      this.count = 1;
    }

    public int incCount() {
      count++;
      return count;
    }

    public int decCount() {
      count--;
      return count;
    }
  }

  private static final String NOT_FOUND = "";

  private Map<String, Node> data;
  private Node head;
  private Node tail;

  /**
   * Initialize your data structure here.
   */
  public Solution1033A() {
    data = new HashMap<>();
  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    if (data.containsKey(key)) {
      Node node = data.get(key);
      node.incCount();
      adjustOrderIfNeed(node);
    } else {
      Node node = new Node(key);
      data.put(key, node);
      addToTail(node);
    }
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    if (data.containsKey(key)) {
      Node node = data.get(key);
      node.decCount();
      if (node.count == 0) {
        data.remove(node.value);
      }
      adjustOrderIfNeed(node);
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    if (head != null) {
      return head.value;
    } else {
      return NOT_FOUND;
    }
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    if (tail != null) {
      return tail.value;
    } else {
      return NOT_FOUND;
    }
  }

  private void adjustOrderIfNeed(Node node) {
    if (node.count == 0) {
      // remove 
      if (node.previous != null) {
        node.previous.next = node.next;
      }
      if (node.next != null) {
        node.next.previous = node.previous;
      }
      if (head == node) {
        head = node.next;
      }
      if (tail == node) {
        tail = node.previous;
      }
    } else {
      Node current = node;
      // move forward if node's count greater than previous's
      while (current.previous != null && current.previous.count < current.count) {
        Node previous = current.previous;
        Node previousOfPrevious = previous.previous;
        Node next = current.next;
        if (next != null) {
          next.previous = previous;
        }
        previous.next = next;
        previous.previous = current;
        current.next = previous;
        current.previous = previousOfPrevious;
        if (previousOfPrevious != null) {
          previousOfPrevious.next = current;
        }
        if (head == previous) {
          head = current;
        }
        if (tail == current) {
          tail = previous;
        }
      }
      // move backward if node's count less than next's
      while (current.next != null && current.next.count > current.count) {
        Node previous = current.previous;
        Node next = current.next;
        Node nextOfNext = next.next;

        next.previous = previous;
        next.next = current;
        if (previous != null) {
          previous.next = next;
        }
        current.next = next.next;
        current.previous = next;
        if (head == current) {
          head = next;
        }
        if (tail == next) {
          tail = current;
        }
      }
    }
  }

  private void addToTail(Node node) {
    if (tail != null) {
      tail.next = node;
      node.previous = tail;
      tail = node;
    } else {
      tail = node;
      head = tail;
    }
  }

}

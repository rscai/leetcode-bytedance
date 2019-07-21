package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.List;

public class Solution1013A {

  public String simplifyPath(String path) {
    List<String> nodes = extractNodes(path);
    StringBuilder builder = new StringBuilder();
    for (String node : nodes) {
      builder.append("/");
      builder.append(node);
    }
    if (builder.length() == 0) {
      return "/";
    } else {
      return builder.toString();
    }
  }

  private List<String> extractNodes(String path) {
    List<String> nodes = new ArrayList<>();
    StringBuilder node = new StringBuilder();
    final int start = 0;
    final int waitForMoreNodeChar = 1;
    final int receivedDot = 2;
    final int receivedTwoDot = 3;
    int state = start;
    for (char ch : (path + "/").toCharArray()) {
      if (state == start) {
        if (ch == '/') {
          // keep state
        } else if (ch == '.') {
          // transit state
          state = receivedDot;
        } else {
          node.append(ch);
          state = waitForMoreNodeChar;
        }
      } else if (state == waitForMoreNodeChar) {
        if (ch == '/') {
          nodes.add(node.toString());
          node = new StringBuilder();
          state = start;
        } else {
          node.append(ch);
        }
      } else if (state == receivedDot) {
        if (ch == '/') {
          // do nothing
          state = start;
        } else if (ch == '.') {
          state = receivedTwoDot;
        } else {
          node.append('.');
          node.append(ch);
          state = waitForMoreNodeChar;
        }
      } else if (state == receivedTwoDot) {
        if (ch == '/') {
          if (nodes.size() > 0) {
            nodes.remove(nodes.size() - 1);
          }
          state = start;
        } else {
          node.append("..");
          node.append(ch);
          state = waitForMoreNodeChar;
        }
      }
    }
    return nodes;
  }
}

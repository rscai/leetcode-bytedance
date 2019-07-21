package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1044A {

  public List<String> restoreIpAddresses(String s) {
    List<List<String>> addresses = restore(s, 4);
    List<String> validAddresses = new ArrayList<>();
    for (List<String> address : addresses) {
      boolean isValid = true;
      for (String i : address) {
        if (i.startsWith("0") && Integer.valueOf(i) != 0) {
          isValid = false;
          break;
        }
        if (i.length() > 1 && Integer.valueOf(i) == 0) {
          isValid = false;
          break;
        }
        if (Integer.valueOf(i) > 255) {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        validAddresses.add(String
            .format("%s.%s.%s.%s", address.get(0), address.get(1), address.get(2), address.get(3)));
      }
    }
    return validAddresses;
  }

  private List<List<String>> restore(String s, int count) {
    if (s.length() == 0) {
      return Collections.emptyList();
    }
    if (count == 1 && s.length() > 3) {
      return Collections.emptyList();
    }
    if (count == 1) {
      return Collections.singletonList(Collections.singletonList(s));
    }
    List<List<String>> results = new ArrayList<>();
    for (int i = 1; i < Math.min(4, s.length()); i++) {
      String e = s.substring(0, i);
      String remainStr = s.substring(i, s.length());
      for (List<String> remain : restore(remainStr, count - 1)) {
        List<String> merged = new ArrayList<>();
        merged.add(e);
        merged.addAll(remain);
        results.add(merged);
      }
    }
    return results;
  }
}

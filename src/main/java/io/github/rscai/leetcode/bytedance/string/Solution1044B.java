package io.github.rscai.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1044B {

  public List<String> restoreIpAddresses(String s) {
    List<List<String>> addresses = restore(s, 4);
    List<String> formatedAddresses = new ArrayList<>();
    for (List<String> address : addresses) {

      formatedAddresses.add(String
          .format("%s.%s.%s.%s", address.get(0), address.get(1), address.get(2), address.get(3)));
    }
    return formatedAddresses;
  }

  private List<List<String>> restore(String s, int count) {
    if (s.length() == 0) {
      return Collections.emptyList();
    }
    if (count == 1 && s.length() > 3) {
      return Collections.emptyList();
    }
    if (count == 1) {
      if (isValid(s)) {
        return Collections.singletonList(Collections.singletonList(s));
      } else {
        return Collections.emptyList();
      }
    }
    List<List<String>> results = new ArrayList<>();
    for (int i = 1; i < Math.min(4, s.length()); i++) {
      String e = s.substring(0, i);
      if (!isValid(e)) {
        continue;
      }
      String remainStr = s.substring(i, s.length());
      if (remainStr.length() < count - 1) {
        continue;
      }
      if (remainStr.length() > 3 * (count - 1)) {
        continue;
      }
      for (List<String> remain : restore(remainStr, count - 1)) {
        List<String> merged = new ArrayList<>();
        merged.add(e);
        merged.addAll(remain);
        results.add(merged);
      }
    }
    return results;
  }

  private boolean isValid(String e) {
    if (e.startsWith("0") && Integer.valueOf(e) != 0) {
      return false;
    }
    if (e.length() > 1 && Integer.valueOf(e) == 0) {
      return false;
    }
    if (Integer.valueOf(e) > 255) {
      return false;
    }
    return true;
  }
}

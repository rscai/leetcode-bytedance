package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1031B {

  public int maxEnvelopes(int[][] envelopes) {
    List<int[]> envelopeInList = new ArrayList<>(envelopes.length);
    for (int[] envelope : envelopes) {
      envelopeInList.add(envelope);
    }
    Collections.sort(envelopeInList, new Comparator<int[]>() {
      @Override
      public int compare(int[] left, int[] right) {
        if (left[0] < right[0]) {
          return -1;
        } else if (left[0] > right[0]) {
          return 1;
        } else {
          if (left[1] < right[1]) {
            return -1;
          } else if (left[1] > right[1]) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    });
    int[] maxs = new int[envelopeInList.size()];
    for (int index = 0; index < envelopeInList.size(); index++) {
      int[] envelope = envelopeInList.get(index);
      int canHoldMax = 0;
      for (int k = index - 1; k >= 0; k--) {
        int[] inner = envelopeInList.get(k);
        if (envelope[0] > inner[0] && envelope[1] > inner[1] && maxs[k] > canHoldMax) {
          canHoldMax = maxs[k];
        }
      }
      maxs[index] = canHoldMax + 1;
    }
    int max = 0;
    for (int value : maxs) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }
}

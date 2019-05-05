package io.github.rscai.leetcode.bytedance.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1031A {

  public int maxEnvelopes(int[][] envelopes) {
    int envelopeCount = envelopes.length;
    int max =0;
    List<int[]> envelopeInList = new ArrayList<>(envelopeCount);
    for (int index = 0; index < envelopeCount; index++) {
      envelopeInList.add(envelopes[index]);
    }
    for (int n = 1; n <= envelopeCount; n++) {
      for (List<int[]> permutation : permute(envelopeInList, n)) {
        if (isValid(permutation) && permutation.size() > max) {
          max = permutation.size();
        }
      }
    }
    return max;
  }

  private List<List<int[]>> permute(List<int[]> elements, int n) {
    List<List<int[]>> permutations = new ArrayList<>();
    if (n == 0) {
      permutations.add(Collections.emptyList());
    }
    for (int index = 0; index < elements.size(); index++) {
      int[] firstElement = elements.get(index);
      List<int[]> remainElements = new ArrayList<>();
      remainElements.addAll(elements.subList(0, index));
      remainElements.addAll(elements.subList(index + 1, elements.size()));
      for (List<int[]> remainPermutation : permute(remainElements, n - 1)) {
        List<int[]> permutation = new ArrayList<>();
        permutation.add(firstElement);
        permutation.addAll(remainPermutation);
        permutations.add(permutation);
      }
    }
    return permutations;
  }

  private boolean isValid(List<int[]> permutation) {
    if (permutation.size() == 1) {
      return true;
    }
    int[] outter = permutation.get(0);
    for (int index = 1; index < permutation.size(); index++) {
      int[] inner = permutation.get(index);
      if (inner[0] >= outter[0] || inner[1] >= outter[1]) {
        return false;
      }
      outter = inner;
    }
    return true;
  }
}

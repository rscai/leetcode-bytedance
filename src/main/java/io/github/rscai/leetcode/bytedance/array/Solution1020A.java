package io.github.rscai.leetcode.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1020A {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return deduplicate(result);
  }

  private List<List<Integer>> deduplicate(List<List<Integer>> combinations) {
    List<List<Integer>> listOfSorted = new ArrayList<>();
    for (List<Integer> combination : combinations) {
      List<Integer> mutableCombination = new ArrayList<>(combination);
      Collections.sort(mutableCombination);
      listOfSorted.add(mutableCombination);
    }
    Set<String> accessed = new HashSet<>();
    List<List<Integer>> unique = new ArrayList<>();
    for (List<Integer> combination : listOfSorted) {
      String key = String
          .format("%d-%d-%d", combination.get(0), combination.get(1), combination.get(2));
      if (!accessed.contains(key)) {
        unique.add(combination);
        accessed.add(key);
      }
    }
    return unique;
  }
}

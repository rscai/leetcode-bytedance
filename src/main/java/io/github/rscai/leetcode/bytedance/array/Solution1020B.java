package io.github.rscai.leetcode.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1020B {

  public List<List<Integer>> threeSum(int[] nums) {
    List<Integer> sortedNums = new ArrayList<>();
    for (int num : nums) {
      sortedNums.add(num);
    }
    Collections.sort(sortedNums);
    List<List<Integer>> result = new ArrayList<>();
    for (int firstIndex = 0; firstIndex < sortedNums.size() - 2; firstIndex++) {
      if (sortedNums.get(firstIndex) > 0) {
        break;
      }
      if (firstIndex > 0 && sortedNums.get(firstIndex).equals(sortedNums.get(firstIndex - 1))) {
        continue;
      }
      int secondIndex = firstIndex + 1;
      int thirdIndex = sortedNums.size() - 1;
      while (thirdIndex > secondIndex) {
        if (secondIndex > firstIndex + 1 && sortedNums.get(secondIndex)
            .equals(sortedNums.get(secondIndex - 1))) {
          secondIndex++;
          continue;
        }
        if (thirdIndex < sortedNums.size() - 1 && sortedNums.get(thirdIndex).equals(sortedNums
            .get(thirdIndex + 1))) {
          thirdIndex--;
          continue;
        }
        int sum = sortedNums.get(firstIndex) + sortedNums.get(secondIndex) + sortedNums.get(thirdIndex);
        if (sum == 0) {
          result.add(Arrays
              .asList(sortedNums.get(firstIndex), sortedNums.get(secondIndex), sortedNums.get(thirdIndex)));
          secondIndex++;
          thirdIndex--;
        } else if (sum < 0) {
          secondIndex++;
        } else {
          thirdIndex--;
        }
      }
    }
    return result;
  }
}

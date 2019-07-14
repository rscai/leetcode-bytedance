package io.github.rscai.leetcode.bytedance.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class Solution1012B {

  public int lengthOfLongestSubstring(String s) {
    BiFunction<Integer, Integer, Boolean> isUnique = new BiFunction<Integer, Integer, Boolean>() {
      private Map<List<Integer>, Boolean> cachedAnswers = new HashMap<>();
      private Map<List<Integer>, Set<Character>> charSets = new HashMap<>();

      @Override
      public Boolean apply(Integer start, Integer end) {
        List<Integer> key = Arrays.asList(start, end);
        if (end <= start) {
          charSets.put(key, Collections.emptySet());
          return true;
        }
        if (cachedAnswers.containsKey(key)) {
          return cachedAnswers.get(key);
        }
        return doApplyAndCache(start, end);
      }

      private boolean doApplyAndCache(Integer start, Integer end) {
        List<Integer> key = Arrays.asList(start, end);
        List<Integer> subQuestionKey = Arrays.asList(start + 1, end);
        boolean result =
            apply(start + 1, end) && !charSets.get(subQuestionKey).contains(s.charAt(start));
        if (result) {
          Set<Character> charSet = new HashSet<>(charSets.get(subQuestionKey));
          charSet.add(s.charAt(start));
          charSets.put(key, charSet);
        }
        return result;
      }
    };
    int maxLength = 0;
    for (int start = 0; start < s.length(); start++) {
      for (int end = start + 1; end <= s.length(); end++) {
        if (isUnique.apply(start, end)) {
          maxLength = Math.max(maxLength, end - start);
        }
      }
    }
    return maxLength;
  }
}

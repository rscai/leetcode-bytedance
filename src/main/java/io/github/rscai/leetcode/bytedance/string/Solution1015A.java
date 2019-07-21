package io.github.rscai.leetcode.bytedance.string;


public class Solution1015A {

  private static final int OFFSET = 0x30;

  public String multiply(String num1, String num2) {
    char[] left = new StringBuilder(num1).reverse().toString().toCharArray();
    int[] leftInts = new int[left.length];
    for (int i = 0; i < left.length; i++) {
      leftInts[i] = left[i] - OFFSET;
    }
    char[] right = new StringBuilder(num2).reverse().toString().toCharArray();
    int[] rightInts = new int[right.length];
    for (int i = 0; i < right.length; i++) {
      rightInts[i] = right[i] - OFFSET;
    }
    int[] resultInts = new int[leftInts.length + rightInts.length];
    for (int i = 0; i < rightInts.length; i++) {
      int[] oneMultiplyResult = oneMultiply(leftInts, rightInts[i]);
      resultInts = add(resultInts, oneMultiplyResult, i);
    }
    char[] result = new char[resultInts.length];
    for (int i = 0; i < resultInts.length; i++) {
      result[i] = (char) (resultInts[i] + OFFSET);
    }
    int endPos = result.length - 1;
    while (endPos > 0 && result[endPos] == '0') {
      endPos--;
    }
    return new StringBuffer(String.valueOf(result, 0, endPos + 1)).reverse().toString();
  }

  private int[] oneMultiply(int[] left, int right) {
    int[] result = new int[left.length + 1];
    int carry = 0;
    for (int i = 0; i < left.length; i++) {
      int value = left[i] * right + carry;
      result[i] = value % 10;
      carry = value / 10;
    }
    if (carry > 0) {
      result[result.length - 1] = carry;
    }
    return result;
  }

  private int[] add(int[] left, int[] right, int offset) {
    int carry = 0;
    for (int i = 0; i < right.length; i++) {
      int value = left[i + offset] + right[i] + carry;
      left[i + offset] = value % 10;
      carry = value / 10;
    }
    int index = right.length + offset;
    while (carry > 0) {
      left[index] = (left[index] + carry) % 10;
      carry = (left[index] + carry) / 10;
      index++;
    }
    return left;
  }
}

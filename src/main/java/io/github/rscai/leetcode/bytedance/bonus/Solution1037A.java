package io.github.rscai.leetcode.bytedance.bonus;

public class Solution1037A {

  public boolean validUtf8(int[] data) {
    final int start = 0;
    final int twoByteFirst = 1;
    final int threeByteFirst = 2;
    final int threeByteSecond = 3;
    final int fourByteFirst = 4;
    final int fourByteSecond = 5;
    final int fourByteThird = 6;
    int state = start;
    for (int code : data) {
      if (state == start) {
        if ((code & 0x80) == 0x00) {
          // one byte char
          // stay on start
          state = start;
        } else if ((code & 0xE0) == 0xC0) {
          // two byte char
          state = twoByteFirst;
        } else if ((code & 0xF0) == 0xE0) {
          // three byte char
          state = threeByteFirst;
        } else if ((code & 0xF8) == 0xF0) {
          // four byte char
          state = fourByteFirst;
        } else {
          // invalid
          return false;
        }
      } else if (state == twoByteFirst) {
        if ((code & 0xC0) == 0x80) {
          // second byte of two bytes char
          state = start;
        } else {
          // invalid
          return false;
        }
      } else if (state == threeByteFirst) {
        if ((code & 0xC0) == 0x80) {
          // second byte of two bytes char
          state = threeByteSecond;
        } else {
          // invalid
          return false;
        }
      } else if (state == threeByteSecond) {
        if ((code & 0xC0) == 0x80) {
          // third byte of three bytes char
          state = start;
        } else {
          // invalid
          return false;
        }
      } else if (state == fourByteFirst) {
        if ((code & 0xC0) == 0x80) {
          // second byte of four bytes char
          state = fourByteSecond;
        } else {
          // invalid
          return false;
        }
      } else if (state == fourByteSecond) {
        if ((code & 0xC0) == 0x80) {
          // third byte of four bytes char
          state = fourByteThird;
        } else {
          // invalid
          return false;
        }
      } else if (state == fourByteThird) {
        if ((code & 0xC0) == 0x80) {
          // fourth byte of four bytes char
          state = start;
        } else {
          // invalid
          return false;
        }
      }
    }

    if (state == start) {
      return true;
    } else {
      return false;
    }
  }
}

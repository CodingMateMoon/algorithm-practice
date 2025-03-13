package arrays_strings;

// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4592/

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
 */

public class ReverseString {
    public static char[] reverseString(char[] s) {

        int lastIndex = s.length - 1;
        for (int i = 0; i < (s.length / 2); i++) {

            char temp = s[i];
            s[i] = s[lastIndex];
            s[lastIndex] = temp;
            lastIndex--;
        }
        return s;
    }
}

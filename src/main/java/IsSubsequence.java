// https://leetcode.com/problems/is-subsequence/
/*

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

s의 요소가 순서대로 t의 요소에 매핑되는 것이 있는지 확인. O(n^2) 의 경우 100^104으로 값이 커서 불가.

 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
a, h 등 값을 키, index를 value로 저장하는 hash 생성 후 key가 존재하고 key에 매핑되는 index 위치가 이전 index보다 클 경우
s의 각 요소를 가리키는 포인터와 t의 각 요소를 가리키는 포인터를 통해 요소들을 비교하고 s의 요소가 t의 요소에 속하면 각 포인터들을 하나씩 증가시키기
 */
public class IsSubsequence {

    String source, target;
    int s_length, t_length;

    public boolean isSubsequence_1(String s, String t) {

        int s_index = 0;
        int t_index = 0;
        while(s_index < s.length() && t_index < t.length()) {
            if(s.charAt(s_index) == t.charAt(t_index)) {
                s_index++;
            }
            t_index++;
        }
        return s_index == s.length();
    }
    public boolean isSubsequence_2(String s, String t) {
        this.source = s;
        this.target = t;
        this.s_length = s.length();
        this.t_length = t.length();
        return rec_isSubsequence(0, 0);
    }

    public boolean rec_isSubsequence(int s_index, int t_index) {
        if (s_index == this.s_length) {
            return true;
        }
        if (t_index == this.t_length) {
            return false;
        }

        if (source.charAt(s_index) == target.charAt(t_index)) {
            s_index++;
        }
        t_index++;
        return rec_isSubsequence(s_index, t_index);
    }

    public boolean isSubsequence_3(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
    public boolean isSubsequence_4(String s, String t) {
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (letterIndicesTable.containsKey(t.charAt(i))) {
                letterIndicesTable.get(t.charAt(i)).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }

        // 소스 문자열 요소 순회 중 일치하는게 없으면 false 모든 요소가 일치하는게 있으면 true
        Integer currentMatchIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!letterIndicesTable.containsKey(s.charAt(i))) {
                return false;
            }
            boolean isMatch = false;
            for (Integer index : letterIndicesTable.get(s.charAt(i))) {
                if (currentMatchIndex < index) {
                    currentMatchIndex = index;
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence(String s, String t) {

        Integer sourceLen = s.length(), targetLen = t.length();
        // the source string is empty
        if (sourceLen == 0)
            return true;
    }
}

package arrays_strings;

//https://leetcode.com/problems/edit-distance/description/

/*
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

    }

    int recur(String word1, String word2, int word1Length, int word2Length) {

        if (word1 == null) {
            return word2Length;
        }
        if (word2 == null) {
            return word1Length;
        }
        if (word1.charAt(word1Length - 1) == word2.charAt(word2Length - 1)) {
            return recur(word1, word2, word1Length - 1, word2Length - 1);
        } else {

        }
    }
}


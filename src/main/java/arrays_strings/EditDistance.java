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

    int memo[][];

    public int minDistance_1(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        return recur(word1, word2, word1.length(), word2.length());
    }

    int recur(String word1, String word2, int word1Length, int word2Length) {

        if (word1Length == 0) {
            return word2Length;
        }
        if (word2Length == 0) {
            return word1Length;
        }
        if (memo[word1Length][word2Length] != 0) {
            return memo[word1Length][word2Length];
        }
        int minDistance = 0;
        if (word1.charAt(word1Length - 1) == word2.charAt(word2Length - 1)) {
            return recur(word1, word2, word1Length - 1, word2Length - 1);
        } else {
            int removeOperation = recur(word1, word2, word1Length - 1, word2Length);
            int insertOperation = recur(word1, word2, word1Length, word2Length - 1);
            int replaceOperation = recur(word1, word2, word1Length - 1, word2Length - 1);

            minDistance = (Math.min(removeOperation, Math.min(insertOperation, replaceOperation)) + 1);
            memo[word1Length][word2Length] = minDistance;
            return minDistance;
        }
    }

    public int minDistance(String word1, String word2) {
       int word1Length = word1.length();
       int word2Length = word2.length();

       if (word1Length == 0) {
           return word2Length;
       }
       if (word2Length == 0) {
           return word1Length;
       }

       int dp[][] = new int[word1Length + 1][word2Length + 1];
       for (int word1Index = 1; word1Index <= word1Length; word1Index++) {
           dp[word1Index][0] = word1Index;
       }

       for (int word2Index = 1; word2Index <= word2Length; word2Index++) {
           dp[0][word2Index] = word2Index;
       }
    }
}


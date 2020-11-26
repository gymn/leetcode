package hard.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class S_72 {
    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return cal(word1, word2, 0, 0);
    }

    private int cal(String word1, String word2, int i, int j) {
        if (i == word1.length() || j == word2.length()) {
            if (i < word1.length()) {
                return word1.length() - i;
            } else {
                return word2.length() - j;
            }
        } else if (dp[i][j] >= 0) {
            return dp[i][j];
        } else {
            if (word1.charAt(i) == word2.charAt(j)) {
                int res = cal(word1, word2, i + 1, j + 1);
                dp[i][j] = res;
                return res;
            } else {
                int tmp = Math.min(cal(word1, word2, i + 1, j), cal(word1, word2, i, j + 1));
                int res = 1 + Math.min(tmp, cal(word1, word2, i + 1, j + 1));
                dp[i][j] = res;
                return res;
            }
        }
    }
}

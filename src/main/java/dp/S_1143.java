package dp;

public class S_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int r = text1.length(), c = text2.length();
        if (r == 0 || c == 0) {
            return 0;
        }
        int[][] dp = new int[r + 1][c + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[c - 1][r - 1];
    }
}
package medium;

/**
 * imp:*****
 * Created by ad on 2017/6/13.
 */
public class S_010 {
    /**
     * Implement regular expression matching with support for '.' and '*'.
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     */
    public static boolean isMatch(String s, String p) {
        if (p == null || s == null)
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++)
            dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];

        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    else
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                }
            }

        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaa", "ab*a"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }
}

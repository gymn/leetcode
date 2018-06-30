package Hard;

/**
 * Created by ad on 2017/6/21.
 */
public class S_32 {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.

     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */
    /**
     * with stack
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int longest = 0;

        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            if (i - dp[i - 1] - 1 >= 0 && s.charAt(i) == ')' && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                longest = Math.max(dp[i], longest);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(longestValidParentheses(s));
    }
}

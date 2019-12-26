package medium.dp;

import org.junit.Assert;
import org.junit.Test;

public class S_91 {
    /**
     * 看i和i-1能不能和
     * 不能合也不能拆-》无解返回0
     * 只能合-》dp[i]=dp[i-2]
     * 只能分->dp[i]=dp[i-1]
     * 能和又能分->dp[i]=dp[i-1]+dp[i-2]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.equals("") || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];

        dp[0] = 1;
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                } else {
                    dp[i] = i == 1 ? 1 : dp[i - 2];
                }
            } else {
                int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                if (num < 10 || num > 26) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = i == 1 ? 2 : dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(numDecodings("0"), 0);
        Assert.assertEquals(numDecodings("01"), 0);
        Assert.assertEquals(1, numDecodings("10"));
        Assert.assertEquals(numDecodings("50"), 0);
        Assert.assertEquals(numDecodings("101"), 1);
        Assert.assertEquals(numDecodings("111"), 3);
    }
}

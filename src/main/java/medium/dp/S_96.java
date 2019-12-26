package medium.dp;

public class S_96 {
    /**
     * dp[0]=1
     * dp[1]=1
     * dp[i]=dp[i-1-1]*dp[n-i-1]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new S_96().numTrees(4));
    }
}

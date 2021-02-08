package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 */
public class S_322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (dp[i][j - coins[i - 1]] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = 1; j < dp.length; j++) {
                if (j < coin) {
                    dp[j] = dp[j];
                } else if (dp[j - coin] == -1) {
                    dp[j] = dp[j];
                } else if (dp[j] == -1) {
                    dp[j] = dp[j - coin] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        int[] coins = {1, 5, 3};
        System.out.println(coinChange2(coins, 11));
    }
}

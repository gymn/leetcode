package dp;

import org.junit.Test;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 */
public class S_474 {
    /**
     * 三维dp，dp[i][j][k]表示数组中前i个元素中满足0的个数不大于j，1的个数不大于k的最大子集合的大小
     * 对于0-1背包问题，计算dp[i][j][k]考虑第i个物品放入背包和不放入两种场景；
     * 不放入：dp[i][j][k] = dp[i-1][j][k]
     * 放入：dp[i][j][k] = dp[i-1][j-zeros[i]][k-ones[i]]+1
     * 因为要计算最大子集，所以最终推导公式为：dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-zeros[i]][k-ones[i]]+1)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            zeros[i] = getCharCount(strs[i], '0');
            ones[i] = getCharCount(strs[i], '1');
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];


        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    if (j < zeros[i - 1] || k < ones[i - 1]) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros[i - 1]][k - ones[i - 1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    /**
     * 对上面解法进行空间压缩可以得到优化后的解法二
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            zeros[i] = getCharCount(strs[i], '0');
            ones[i] = getCharCount(strs[i], '1');
        }
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= zeros[i]; j--) {
                for (int k = n; k >= ones[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i]][k - ones[i]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int getCharCount(String s, char c) {
        int count = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        String[] strs = {"10", "0", "1"};
        System.out.println(findMaxForm2(strs, 1, 1));
    }
}

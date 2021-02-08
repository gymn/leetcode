package medium.dp;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 求解数组中连续等差数列的个数
 */
public class S_413 {
    /**
     * 解法：动态规划
     * dp[i]代表数组中以第i个元素结尾的等差的数列个数
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int sum = 0;
        for (int n : dp) {
            sum += n;
        }
        return sum;
    }
}
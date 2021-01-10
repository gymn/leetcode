package jzoffer;

import org.junit.Test;

/**
 * 求出整型数组中连续子数组的最大和
 */
public class JZ_042 {

    /**
     * 解法一
     * 暴力破解法：计算每个子数组的和，取最大的和；
     * 因为要遍历所有区间，时间复杂度为O(n^2),空间复杂度O(1)
     */
    public int maxSubArray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp + nums[j];
                maxVal = Math.max(tmp, maxVal);
            }
        }
        return maxVal;
    }

    /**
     * 解法二
     * 动态规划法
     * 我们可以用dp[i]代表数组中以nums[i]为结尾的连续子数组最大和，为什么一定要以nums[i]为结尾？因为要保证数组的连续性。
     * 当dp[i-1]<=0时dp[i-1]对dp[i]是负贡献或0贡献，这部分前缀是可以直接丢弃掉的。下面以dp[i]开头重新计算即可。所以递推表达式为：
     * dp[i]=dp[i-1]<=0?nums[i]:dp[i-1]+nums[i]
     * <p>
     * 又因为dp[i]只与dp[i-1]有关，所以我们需要建立dp数组，只需要用一个变量存储dp[i-1]即可
     */
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = dp <= 0 ? nums[i] : dp + nums[i];
            ans = Math.max(ans, dp);
        }
        return ans;
    }



    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }
}

package dp;

import org.junit.Test;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class S_416 {
    /**
     * 解法一：
     * 暴力法，遍历所有数组的子集，判断和是否为数组和得一半即可，为了遍历所有的子集，我们需要维护一个数组用于记录nums中每个数字是否在集合中，
     * 0-表示不放入集合，1-表示放入集合
     */
    int[] mark;
    boolean ans;

    public boolean canPartition(int[] nums) {
        mark = new int[nums.length];
        ans = false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dfs(0, nums, sum / 2);
        return ans;
    }

    private void dfs(int start, int[] nums, int target) {
        if (ans) {
            return;
        }
        if (start == nums.length) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += mark[i] * nums[i];
            }
            if (sum == target) {
                ans = true;
            }
        } else {
            mark[start] = 1;
            dfs(start + 1, nums, target);
            mark[start] = 0;
            dfs(start + 1, nums, target);
        }
    }

    /**
     * 解法二：
     * 我们可以将这个问题转化为背包问题，即从判断是否可以从nums中选择几个数字，使得这些数字的和为总和得一半；
     * 背包的解题思路是每次只考虑前i个物品，然后逐步逼近目标条件。本题中物品即为数组中的整数，目标条件是sum/2
     * dp[i][j]的含义是能否从数组前i个元素中选取一个子集，使其总和为j。
     * 初始化：
     * dp[0~n][0]=true，因为目标和是0，每次取空集合就可以了
     * dp[0][1~m]=false，因为数组中都是正整数，那么目标和也必然是正整数，数组中前0个数字是不可能总和为整数的
     * 推导公式：
     * 如果j>=nums[i] => dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]] 否则dp[i][j]=dp[i-1][j]
     * dp[i-1][j]对应是不将nums[i]放入子集的情况，dp[i-1][j-nums[i]]对应的是放入的情况，任意情况满足加总为j，则dp[i][j]为true
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 > 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (boolean[] ints : dp) {
            ints[0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = j >= nums[i - 1] ? dp[i - 1][j] || dp[i - 1][j - nums[i - 1]] : dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][target];
    }

    /**
     * 解法三：
     * 根据解法二的思路，我们可以发现：dp[i][j]只依赖上一行的结果，所以可以进行空间压缩，将空间复杂度降低到O(sum/2)
     * 推导公式为：dp[j] = dp[j]||dp[j-nums[i]], 但是我们只能从右到左计算，因为如果从左到右计算会把前一次的计算结果提前覆盖掉
     */
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 > 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                dp[j] = j >= nums[i - 1] ? dp[j] || dp[j - nums[i - 1]] : dp[j];
            }
        }
        return dp[target];
    }


    @Test
    public void test() {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition3(nums));
    }
}
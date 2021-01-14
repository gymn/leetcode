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
     * 我们可以将这个问题转化为背包问题，即从判断是否可以从nums中选择几个数字，使得这些数字的和为总和得一半
     */
    public boolean canPartition2(int[] nums) {
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


    @Test
    public void test() {
        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        System.out.println(canPartition(nums));
    }
}
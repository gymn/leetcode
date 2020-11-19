package easy;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class S_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (n != i) {
                    int tmp = nums[n];
                    nums[n] = nums[i];
                    nums[i] = tmp;
                }
                n++;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {2, 1};
        moveZeroes(nums);
        System.out.println(nums);
    }
}

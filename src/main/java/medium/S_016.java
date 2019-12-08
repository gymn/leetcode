package medium;

import org.junit.Test;

import java.util.Arrays;

public class S_016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int closeSum = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(closeSum - target);


        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    closeSum = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return closeSum;
    }

    @Test
    public void testThreeSumClosest() {
        int[] nums = {1, 2, 4,8, 16,32,64,128};
        System.out.println(threeSumClosest(nums, 82));
    }
}

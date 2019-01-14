package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hunan
 * @Date 2018/12/30
 * @Time 5:33 PM
 */
public class S_015 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] > 0) {
                    break;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);

                    do {
                        end--;
                    } while (start < end && nums[end] == nums[end + 1]);
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> res = new S_015().threeSum(nums);
        System.out.println(res);
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start <= end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        while (end >= start && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,0,0,0,1,2,3};
        new S_018().fourSum(arr, 0).forEach(System.out::println);
    }
}

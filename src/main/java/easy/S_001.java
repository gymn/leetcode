package easy;

import org.junit.Test;
import util.ShowUtils;

import java.util.HashMap;
import java.util.Map;

public class S_001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            Integer index = map.get(diff);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return new int[0];
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 4};
        ShowUtils.show(twoSum(nums, 6));
    }
}

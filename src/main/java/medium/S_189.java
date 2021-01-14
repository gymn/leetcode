package medium;

import org.junit.Test;
import util.ShowUtils;

public class S_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    public void rotate_2(int[] nums, int k) {

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        ShowUtils.show(nums);
    }
}

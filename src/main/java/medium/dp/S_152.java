package medium.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 16:31
 */
public class S_152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int zeroIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIdx + 1 <= i - 1) {
                    max = Math.max(max, max_product(nums, zeroIdx + 1, i - 1));
                }
                zeroIdx = i;
            }
        }

        if (zeroIdx < nums.length - 1) {
            max = Math.max(max, max_product(nums, zeroIdx + 1, nums.length - 1));
        }


        if (zeroIdx > -1 && max < 0) {
            max = 0;
        }
        return max;
    }

    private int max_product(int[] nums, int start, int end) {
        List<Integer> pos = new ArrayList<>();
        int p = 1;
        for (int i = start; i <= end; i++) {
            p = p * nums[i];
            if (nums[i] < 0) {
                pos.add(i);
            }
        }

        if (p > 0) {
            return p;
        }

        if (start == end) {
            return p;
        }

        int tmp1 = p;
        for (int i = start; i <= pos.get(0); i++) {
            tmp1 /= nums[i];
        }

        int tmp2 = p;
        for (int i = pos.get(pos.size() - 1); i <= end; i++) {
            tmp2 /= nums[i];
        }
        return Math.max(tmp1, tmp2);
    }

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
    }
}

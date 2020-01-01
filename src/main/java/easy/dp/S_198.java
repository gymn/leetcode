package easy.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 17:42
 */
public class S_198 {
    /**
     * 1 ms
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return doRob(nums, 0);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    private int doRob(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        Integer r1 = memo.get(start + 1);
        if (r1 == null) {
            r1 = doRob(nums, start + 1);
            memo.put(start + 1, r1);
        }
        Integer r2 = memo.get(start + 2);
        if (r2 == null) {
            r2 = doRob(nums, start + 2);
            memo.put(start + 2, r2);
        }
        return Math.max(nums[start] + r2, r1);
    }

    /**
     * dp公式：f(n) = max(f(n-1), f(n-2)+f(n))
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int pre = 0; //f(n-2)
        int cur = 0; //f(n-1)

        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new S_198().rob2(new int[]{2}));
    }
}

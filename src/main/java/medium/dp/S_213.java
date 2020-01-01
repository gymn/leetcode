package medium.dp;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 20:18
 */
public class S_213 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int pre = 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }

        int pre2 = 0;
        int cur2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = cur2;
            cur2 = Math.max(cur2, pre2 + nums[i]);
            pre2 = tmp;
        }
        return Math.max(cur, cur2);
    }
}

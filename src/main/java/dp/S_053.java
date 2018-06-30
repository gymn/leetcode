package dp;

/**
 * EASY
 * Created by ad on 2017/7/6.
 */
public class S_053 {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * <p>
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */

    /**
     * dp解法，O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxVal = nums[0], currentVal = nums[0];
        for(int i=1; i<nums.length; i++){
            currentVal = currentVal>0?currentVal+nums[i]:nums[i];
            maxVal = maxVal<currentVal?currentVal:maxVal;
        }
        return maxVal;
    }
}

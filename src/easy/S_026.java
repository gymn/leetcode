package easy;

/**
 * Created by ad on 2017/8/10.
 */
public class S_026 {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     */
    public static int removeDuplicates(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<2)
            return nums.length;

        int count = nums.length;
        for(int i=1;i<count;i++){
            if(nums[i]==nums[i-1]) {
                for(int j=i;j<count-1;j++){
                    nums[j] = nums[j+1];
                }
                count--;
                i--;
            }
        }
        return count;
    }

    //more efficient
    public static int removeDuplicates2(int[] nums){
        if(nums==null)
            return 0;
        if(nums.length<2)
            return nums.length;

        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]) {
                ++i;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3};
        System.out.println(removeDuplicates2(nums));

        for(int n:nums)
            System.out.print(n+" ");
    }
}

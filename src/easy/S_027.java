package easy;

/**
 * Created by ad on 2017/8/10.
 */
public class S_027 {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.
     The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)
            return 0;
        int i=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3};

        int len = removeElement(arr,3);

        for(int i=0;i<len;i++)
            System.out.print(arr[i]+" ");
    }
}

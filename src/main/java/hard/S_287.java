package hard;

public class S_287 {
	//暴力4.7%
	public int findDuplicate(int[] nums) {
		for(int i =0;  i<nums.length; i++){
			for(int j =i+1; j<nums.length; j++){
				if(nums[i] == nums[j]) return nums[i];
			}
		}
		return 0;
    }
   //二分22.5%
	public int  findDuplicate_1(int[] nums) {
		int len = nums.length;
		int count = 0, min = 1, max = len - 1;		
		while(min <= max){
			int mid = (min + max)/2;
			for(int i :nums){
				if(i <=mid )
					count ++;
			}
			if(count > mid)
				max = mid -1;
			else
				min = mid + 1;
			count = 0;
		}
		return min;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,3};
		System.out.println(new S_287().findDuplicate_1(nums));
	}

}

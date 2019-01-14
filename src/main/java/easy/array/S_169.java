package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hunan
 * @Date 2018/6/30
 * @Time 下午9:42
 * 求众数
 */
public class S_169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            Integer count = numberMap.getOrDefault(nums[i],0)+1;
            if(count>=nums.length/2d){
                return nums[i];
            }
            numberMap.put(nums[i],count);
        }
        return 0;
    }
}

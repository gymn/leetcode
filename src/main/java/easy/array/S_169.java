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
<<<<<<< HEAD

=======
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
>>>>>>> b4a82650c2e9c1398116fdcec3e9f4953cbcc2a3
}

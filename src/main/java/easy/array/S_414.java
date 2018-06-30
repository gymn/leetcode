package easy.array;

import java.util.TreeSet;

/**
 * @Author hunan
 * @Date 2018/5/29
 * @Time 下午10:47
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class S_414 {
    /**
     * 21ms
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()<3){
            return set.last();
        }
        set.pollLast();
        set.pollLast();
        return set.last();
    }
}

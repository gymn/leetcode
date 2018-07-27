package easy.array;

/**
 * @Author hunan
 * @Date 2018/7/26
 * @Time 下午8:15
 */
public class S_645 {
    public int[] findErrorNums(int[] nums) {
        int[] tmpArray = new int[nums.length+1];
        int[] res = new int[2];

        for (int num : nums) {
            if (tmpArray[num] > 0) {
                res[0] = num;
            } else {
                tmpArray[num] = num;
            }
        }

        for (int i = 1; i < tmpArray.length; i++) {
            if (tmpArray[i] == 0) {
                res[1] = i;
                break;
            }
        }

        return res;
    }
}

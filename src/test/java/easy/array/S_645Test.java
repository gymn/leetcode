package easy.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author hunan
 * @Date 2018/7/26
 * @Time 下午8:23
 */
public class S_645Test {

    @Test
    public void findErrorNums() {
        S_645 s_645 = new S_645();
        int[] nums = {1, 2, 2, 4};
        int[] res = s_645.findErrorNums(nums);
        assertArrayEquals(new int[]{2,3}, res);
    }
}
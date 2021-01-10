package jzoffer;

import org.junit.Test;

public class JZ_003 {
    /**
     * 解法一：
     * 建立一个长度为n的数组，用于对nums中的元素计数，遇到大于1的直接返回。也可以用HashSet实现重复值判断。
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int n : nums) {
            if (arr[n] > 0) {
                return n;
            } else {
                arr[n]++;
            }
        }
        return -1;
    }

    /**
     * 解法二：
     * 作为解法一的升级版，在允许修改nums的前提下，我们其实可以直接用原数组进行计数，即遍历nums，将当前元素值交换到对应下标的位置，
     * 如果发现对应下标的值已经和下标相等则说明发现重复值了
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != i) {
                if (nums[value] == value) {
                    return value;
                } else {
                    int tmp = nums[value];
                    nums[value] = value;
                    nums[i] = tmp;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
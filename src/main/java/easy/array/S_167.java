package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hunan
 * @Date 2018/6/30
 * @Time 下午1:51
 * 两数之和 II - 输入有序数组
 */
public class S_167 {
    private int biSearch(int[] numbers, int start, int end, int target) {
        while (start <= end) {
            int middle = (start + end) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * nlogn 超时
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int n = target - numbers[i];
            int index2 = biSearch(numbers, i + 1, numbers.length - 1, n);
            if (index2 > i) {
                indices[0] = i + 1;
                indices[1] = index2 + 1;
                return indices;
            }
        }
        return null;
    }

    /**
     * 借助hashmap后30%
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int[] indices = new int[2];
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numberMap.containsKey(target - numbers[i])) {
                indices[0] = numberMap.get(target - numbers[i]) + 1;
                indices[1] = i + 1;
                return indices;
            }
            numberMap.put(numbers[i], Math.min(numberMap.getOrDefault(numbers[i], i), i));
        }
        return indices;
    }

    public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int start = 0;
        int end = numbers.length - 1;
        float center = target / 2;

        while (end - start > 1) {
            int middle = (start + end) / 2;
            if (numbers[middle] == center) {
                if(middle>0&&numbers[middle-1]==center) {
                    start = middle-1;
                    end = middle;
                }else{
                    start = middle;
                    end = middle+1;
                }
                break;
            }

            if (numbers[middle] > center) {
                end = middle;
            }

            if (numbers[middle] < center) {
                start = middle;
            }
        }

        while (numbers[start] + numbers[end] != target) {
            if (numbers[start] + numbers[end] < target) {
                ++end;
            } else {
                --start;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}

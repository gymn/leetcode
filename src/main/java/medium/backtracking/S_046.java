package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hunan
 * @date 2020-02-24
 * @time 21:50
 */
public class S_046 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        backtracking(numList, 0, result);
        return result;
    }

    private void backtracking(List<Integer> nums, int level, List<List<Integer>> ans) {
        if (level == nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int i = level; i < nums.size(); i++) {
            swap(nums, i, level);
            backtracking(nums, level + 1, ans);
            swap(nums, i, level);
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        if (i == j) {
            return;
        }
        Integer tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    @Test
    public void test() {
        int[] candidates = new int[]{1, 2, 3};
        System.out.println(permute(candidates));
    }
}

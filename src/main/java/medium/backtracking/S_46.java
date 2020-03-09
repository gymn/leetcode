package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hunan
 * @date 2020-02-24
 * @time 21:50
 */
public class S_46 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        compute(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private void compute(int[] nums, boolean[] record, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < record.length; i++) {
            if (!record[i]) {
                path.add(nums[i]);
                record[i] = true;
                compute(nums, record, path);
                record[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = new int[]{1, 2, 3};
        System.out.println(permute(candidates));
    }
}

package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author hunan
 * @date 2020-02-23
 * @time 22:36
 */
public class S_40 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        doCompute(candidates, target, 0);

        return result;
    }

    private void doCompute(int[] candidates, int target, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target > 0 && i < candidates.length) {
            for (int j = i; j < candidates.length; j++) {
                if (j > i && candidates[j] == candidates[j - 1] || target < candidates[j]) {
                    continue;
                }
                path.add(candidates[j]);
                doCompute(candidates, target - candidates[j], j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}

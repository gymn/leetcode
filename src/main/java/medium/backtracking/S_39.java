package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hunan
 * @date 2020-02-16
 * @time 20:42
 */
public class S_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        return doCombination(candidates, target, 0);
    }

    private List<List<Integer>> doCombination(int[] candidates, int target, int i) {
        List<List<Integer>> result = new ArrayList<>();
        for (int j = i; j < candidates.length; j++) {
            int candidate = candidates[j];
            if (target < candidate) {
                break;
            } else if (target == candidate) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(candidate);
                result.add(tmp);
                break;
            } else {
                List<List<Integer>> sub = doCombination(candidates, target - candidate, j);
                if (!sub.isEmpty()) {
                    for (List<Integer> integers : sub) {
                        integers.add(candidate);
                    }
                }
                result.addAll(sub);
            }
        }

        return result;
    }


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        doCombination2(candidates, target, 0);
        return result;
    }

    private void doCombination2(int[] candidates, int target, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (target < candidates[j]) {
                break;
            }

            cur.add(candidates[j]);
            doCombination2(candidates, target - candidates[j], j);
            cur.remove(cur.size()-1);
        }
    }


    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}

package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hunan
 * @date 2020-02-24
 * @time 22:15
 */
public class S_47 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        dfs(nums, new boolean[nums.length], new ArrayList<>(nums.length));

        return result;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, visited, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = new int[]{1, 1, 1, 2};
        System.out.println(permuteUnique(candidates));
    }
}

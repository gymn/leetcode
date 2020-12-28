package medium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S_077 {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1) {
            return Collections.emptyList();
        }

        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, 0, k, ans);
        return ans;
    }

    private void backtracking(List<Integer> nums, int level, int k, List<List<Integer>> ans) {
        if (level == k) {
            ans.add(new ArrayList<>(nums.subList(0, k)));
        }

        if (nums.size() - level >= k - level) {
            for (int i = level; i < nums.size(); i++) {
                if (level == 0 || nums.get(i).compareTo(nums.get(level - 1)) > 0) {
                    swap(nums, level, i);
                    backtracking(nums, level + 1, k, ans);
                    swap(nums, level, i);
                }
            }
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

    /**
     * ---------------------------------------------------------------------------
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine2(int n, int k) {
        if (n < 1) {
            return Collections.emptyList();
        }

        dfs(1, n, k);
        return ans;
    }

    private void dfs(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }

    @Test
    public void test() {
        System.out.println(combine2(4, 2));
    }
}

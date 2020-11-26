package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class S_164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int div = 1;
        List<Integer> tmp = new ArrayList<>(nums.length);
        for (int i = 0; i < 32; i++) {
            List<List<Integer>> bulks = new ArrayList<>(10);
            int maxHash = 0;
            for (int num : nums) {
                int hash = (num / div) % 10;
                maxHash = Math.max(maxHash, hash);
                if (bulks.get(hash) == null) {
                    List<Integer> list = new LinkedList<>();
                    list.add(num);
                    bulks.set(hash, list);
                } else {
                    bulks.get(hash).add(num);
                }
            }

            for (List<Integer> bulk : bulks) {

            }
            if (maxHash == 0) {
                break;
            }
        }
        return 0;
    }
}

package medium.math;

import org.junit.Test;
import util.ShowUtils;

/**
 * @author hunan
 * @date 2020-03-02
 * @time 21:32
 */
public class S_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int result = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                result = result ^ arr[j];
            }
            results[i] = result;
        }
        return results;
    }

    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length + 1];
        pre[0] = 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = pre[queries[i][0]] ^ pre[queries[i][1] + 1];
        }
        return results;
    }

    @Test
    public void test() {
        int[] arr = {1, 11, 1};
        int[][] queries = {{0, 2}, {0, 2}, {2, 2}, {0, 2}};
        int[] results = xorQueries2(arr, queries);
        ShowUtils.show(results);
    }
}

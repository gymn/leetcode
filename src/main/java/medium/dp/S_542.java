package medium.dp;

import org.junit.Test;
import util.ShowUtils;

import java.util.Arrays;

public class S_542 {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int[] a : ans) {
            Arrays.fill(a, Integer.MAX_VALUE - 1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    if (i > 0)
                        ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                    if (j > 0)
                        ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (i < matrix.length - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                    }

                    if (j < matrix[i].length - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                    }
                }
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] matrix = {{0}};
        ShowUtils.show(updateMatrix(matrix));
    }
}

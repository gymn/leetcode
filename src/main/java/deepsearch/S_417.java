package deepsearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_417 {
    int[][] mark;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        mark = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int res = dfs(i, j, matrix, new int[matrix.length][matrix[0].length]);
                if (res == 3) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] searched) {
        if (i < 0 || j < 0) {
            return 1;
        }

        if (i == matrix.length || j == matrix[0].length) {
            return 2;
        }

        if (mark[i][j] > 0) {
            return mark[i][j];
        }

        if (searched[i][j] == 1) {
            return 0;
        }

        int res = mark[i][j];
        if (i == 0 || matrix[i - 1][j] <= matrix[i][j]) {
            searched[i][j] = 1;
            res = res | dfs(i - 1, j, matrix, searched);
        }

        if (j == 0 || matrix[i][j - 1] <= matrix[i][j]) {
            searched[i][j] = 1;
            res = res | dfs(i, j - 1, matrix, searched);
        }

        if (i == matrix.length - 1 || matrix[i + 1][j] <= matrix[i][j]) {
            searched[i][j] = 1;
            res = res | dfs(i + 1, j, matrix, searched);
        }
        if (j == matrix[0].length - 1 || matrix[i][j + 1] <= matrix[i][j]) {
            searched[i][j] = 1;
            res = res | dfs(i, j + 1, matrix, searched);
        }
        return res;
    }

    /**
     * 从两个大洋向上回溯，复杂度会小很多
     */
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int[][] mark = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int res = dfs(i, j, matrix, new int[matrix.length][matrix[0].length]);
                if (res == 3) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs2(int i, int j, int v, int[][] matrix, int[][] mark) {
        
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(matrix));
    }
}

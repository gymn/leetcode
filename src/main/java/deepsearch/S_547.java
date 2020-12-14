package deepsearch;

import org.junit.Test;

public class S_547 {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                count++;
                dfs(i, M);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] M) {
        if (M[i][i] == 0) {
            return;
        }
        M[i][i] = 0;
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1) {
                dfs(j, M);
            }
        }
    }

    @Test
    public void test() {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }
}

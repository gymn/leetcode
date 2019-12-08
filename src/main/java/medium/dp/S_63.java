package medium.dp;

import org.junit.Test;

public class S_63 {
    /**
     * 第一行和列初始化时要特殊处理，从碰到第一个障碍物开始，后面的都是不可达
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (int j = i; j < m; j++) {
                    dp[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                for (int j = i; j < n; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] arr = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}

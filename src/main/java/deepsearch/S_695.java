package deepsearch;

import org.junit.Test;

public class S_695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] searched = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searched[i][j] == 0) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid, searched));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid, int[][] searched) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || searched[i][j] == 1 || grid[i][j] == 0) {
            return 0;
        }

        searched[i][j] = 1;

        return 1 + dfs(i - 1, j, grid, searched) + dfs(i, j - 1, grid, searched) + dfs(i + 1, j, grid, searched) + dfs(i, j + 1, grid, searched);
    }

    @Test
    public void test() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}

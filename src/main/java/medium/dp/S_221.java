package medium.dp;

public class S_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int r = matrix.length, c = matrix[0].length;
        int m = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    int offset = 1;
                    for (; i + offset < r && j + offset < c; offset++) {
                        boolean flag = false;
                        for (int k = 0; k <= offset; k++) {
                            if (matrix[i + k][j + offset] == '0' || matrix[i + offset][j + k] == '0') {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    }
                    m = Math.max(m, offset);
                }
            }
        }
        return m * m;
    }
}

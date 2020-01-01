package medium.dp;

import java.util.List;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 12:18
 */
public class S_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        List<Integer> lastLine = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastLine.size(); i++) {
            dp[i] = lastLine.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                dp[j] = line.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}

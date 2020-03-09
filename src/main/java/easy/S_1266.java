package easy;

import org.junit.Test;

/**
 * @author hunan
 * @date 2020-03-09
 * @time 19:26
 */
public class S_1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int s = 0;
        for (int i = 0; i < points.length - 1; i++) {
            s += minTimeOf2Points(points[i], points[i + 1]);
        }
        return s;
    }

    private int minTimeOf2Points(int[] point1, int[] point2) {
        int l = Math.abs(point1[0] - point2[0]);
        int w = Math.abs(point1[1] - point2[1]);
        return Math.max(l, w);
    }

    @Test
    public void test() {
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }
}

package greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class S_452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                if (o1[1] < o2[1]) {
                    return -1;
                }
                return 0;
            }
        });
        int count = 1;
        int i = 1;
        int arrow = points[0][1];
        while (i < points.length) {
            if (points[i][0] > arrow) {
                arrow = points[i][1];
                count++;
            }
            i++;
        }
        return count;
    }

    @Test
    public void test() {
        int[][] points = {{1, 2}};
        System.out.println(findMinArrowShots(points));
    }
}

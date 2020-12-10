package greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class S_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(a -> a[1]));
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(arr));
    }
}

package medium;

import org.junit.Test;

public class S_1432 {
    /**
     * 解法1：滑动窗口向右移位，记录最大和，时间复杂度O(k)，空间复杂度：O(1)
     */
    public int maxScore(int[] cardPoints, int k) {
        int i = cardPoints.length - k;
        int j = cardPoints.length - 1;
        int sum = 0;
        for (int s = i; s <= j; s++) {
            sum += cardPoints[s];
        }
        if (k == cardPoints.length) {
            return sum;
        }
        int maxSum = sum;

        j = 0;
        for (int s = 0; s < k; s++) {
            sum -= cardPoints[i];
            i++;
            sum += cardPoints[j];
            j++;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    @Test
    public void test() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(maxScore(cardPoints, 3));
    }
}

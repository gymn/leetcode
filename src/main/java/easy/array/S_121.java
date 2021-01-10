package easy.array;

import org.junit.Test;

/**
 * 买卖股票的最佳时机，给定股票每日的价格，求解在最多只操作一次的情况下，能获取的最大股票收益
 */
public class S_121 {
    /**
     * 解法一：
     * 从左到右遍历，如果记录目前为止最小的股票价格，并计算与当前股票价格的差值，取最大差值即可
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrices = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}

package easy.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 买卖股票的最佳时机 II,给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class S_122 {
    /**
     * 解法一：
     * 因为不对股票的交易次数做限制，所以可以在每次股票上涨前买入，股票下跌前卖出。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(maxProfit(prices), 7);
    }
}

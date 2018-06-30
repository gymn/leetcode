package easy.array;

/**
 * @Author hunan
 * @Date 2018/5/27
 * @Time 下午10:03
 * 买卖股票的最佳时机
 */
public class S_121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minIndex = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[minIndex]){
                profit = Math.max(profit,prices[i]-prices[minIndex]);
            }
            if(prices[i]<prices[minIndex]){
                minIndex = i;
            }
        }
        return profit;
    }
}

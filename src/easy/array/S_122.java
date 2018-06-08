package easy.array;

/**
 * @Author hunan
 * @Date 2018/5/27
 * @Time 下午10:50
 * 买卖股票的最佳时机 II
 */
public class S_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minIndex = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<prices[i-1]){
                profit += (prices[i-1]-prices[minIndex]);
                minIndex = i;
            }

            if(i==prices.length-1&&prices[i]>=prices[i-1]){
                profit += (prices[i]-prices[minIndex]);
            }
        }
        return profit;
    }
}

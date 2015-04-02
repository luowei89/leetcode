public class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        int n = prices.length;
        for(int i = 0; i < n; i++){
            if(prices[i] < min_price){
                min_price = prices[i];
            }
            int profit = prices[i] - min_price;
            if(profit > max_profit){
                max_profit = profit;
            }
        }
        return max_profit;
    }
}
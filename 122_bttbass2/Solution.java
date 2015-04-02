public class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i = 0; i < prices.length-1; i++){
            int profit = prices[i+1]-prices[i];
            if(profit > 0){
               max_profit += profit; 
            }
        }
        return max_profit;
    }
}
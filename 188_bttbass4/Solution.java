public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        // Before adding this, Memory Limit Exceeded
        if (k > prices.length / 2) {
            // equals no limit: Best Time to Buy and Sell Stock II
            return maxProfitII(prices);
        }
        // END
        int[] buys = new int[k];
        int[] sells = new int[k];
        for (int i = 0; i < k; i++) {
            buys[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < prices.length; i++) {
            buys[0] = Math.max(buys[0], -prices[i]);
            sells[0] = Math.max(sells[0], prices[i] + buys[0]);
            for (int j = 1; j < k; j++) {
                buys[j] = Math.max(buys[j], sells[j-1] - prices[i]);
                sells[j] = Math.max(sells[j], prices[i] + buys[j]);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < k; i++) {
            if (sells[i] > maxProfit) {
                maxProfit = sells[i];
            }
        }
        return maxProfit;
    }
    
    public int maxProfitII(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                profit += prices[i-1] - minPrice;
                minPrice = prices[i];
            } else if (i == prices.length - 1) {
                profit += prices[i] - minPrice;
            }
        }
        return profit;
    }
}

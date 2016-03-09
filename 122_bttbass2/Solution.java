public class Solution {
    public int maxProfit(int[] prices) {
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

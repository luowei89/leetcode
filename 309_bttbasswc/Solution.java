public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] sell = new int[n];
        int[] cool = new int[n];
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(sell[i-1] + prices[i] - prices[i-1], cool[i-1]);
            cool[i] = Math.max(sell[i-1], cool[i-1]);
        }
        return Math.max(sell[n-1], cool[n-1]);
    }
}

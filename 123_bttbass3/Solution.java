public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buy1 < -prices[i]) {
                buy1 = -prices[i];
            }
            if (buy2 < sell1 - prices[i]) {
                buy2 = sell1 - prices[i];
            }
            if (sell1 < prices[i] + buy1) {
                sell1 = prices[i] + buy1;
            }
            if (sell2 < prices[i] + buy2) {
                sell2 = prices[i] + buy2;
            }
        }
        return sell1 > sell2 ? sell1 : sell2;
    }
}

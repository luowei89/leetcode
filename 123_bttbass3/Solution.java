public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int min = prices[0];
        for(int i = 1; i < n; i++){
            left[i] = left[i-1]>prices[i]-min?left[i-1]:prices[i]-min;
            min = min < prices[i]?min:prices[i];
        }
        int max = prices[n-1];
        for(int i = n-2;i>=0; i--){
            right[i] = right[i+1]> max-prices[i]?right[i+1]:max-prices[i];
            max = max > prices[i]?max:prices[i];
        }
        int max_profit = 0;
        for(int i = 0; i < n; i++){
            max_profit = max_profit> left[i]+right[i]?max_profit:left[i]+right[i];
        }
        return max_profit;
    }
}
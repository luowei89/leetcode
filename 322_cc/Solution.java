public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mins = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            mins[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int x : coins) {
                if (i - x >= 0) {
                    if (mins[i-x] < mins[i] - 1) {
                        mins[i] = mins[i-x] + 1;
                    }
                }
            }
        }
        return mins[amount] == Integer.MAX_VALUE ? -1 : mins[amount];
    }
}

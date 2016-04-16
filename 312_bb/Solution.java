public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] numsPlus = new int[n];
        for (int i = 0; i < n - 2; i++) {
            numsPlus[i + 1] = nums[i];
        }
        numsPlus[0] = numsPlus[n - 1] = 1;
        int[][] coins = new int[n][n];
        for(int len = 2; len < n; len++){
            for(int l = 0; l + len < n; l++){
                int h = l + len;
                for(int m = l + 1; m < h; m++){
                    coins[l][h] = Math.max(coins[l][h], numsPlus[l]  * numsPlus[m] * numsPlus[h] + coins[l][m] + coins[m][h]);
                }
            }
        }
        return coins[0][n-1];
    }
}

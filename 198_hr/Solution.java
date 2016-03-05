public class Solution {
    public int rob(int[] nums) {
        int[] sums = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum1 = nums[i];
            if (i-3 >= 0) {
                sum1 += sums[i-3];
            }
            int sum2 = nums[i];
            if (i-2 >= 0) {
                sum2 += sums[i-2];
            }
            sums[i] = sum1 > sum2 ? sum1 : sum2;
            if (sums[i] > max) {
                max = sums[i];
            }
        }
        return max;
    }
}

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum1 = rob(nums, 0, nums.length - 2);
        int sum2 = rob(nums, 1, nums.length - 1);
        return sum1 > sum2 ? sum1 : sum2;
    }
    
    private int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] sums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum1 = nums[i + start];
            if (i-3 >= 0) {
                sum1 += sums[i-3];
            }
            int sum2 = nums[i + start];
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

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = sum <= 0 ? nums[i] : sum + nums[i];
            maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }
}

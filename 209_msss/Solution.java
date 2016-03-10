public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[end];
                end++;
            } else {
                int length = end - start;
                if (length < minLength) {
                    minLength = length;
                }
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

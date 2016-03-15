public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int absMinDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int left = i+1; 
            int right = n-1;
            while (left < right) {
                int diff = nums[i] + nums[left] + nums[right] - target;
                if (diff == 0) {
                    return target;
                } else if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(diff) < absMinDiff) {
                    minDiff = diff;
                    absMinDiff = Math.abs(minDiff);
                }
            }
        }
        return minDiff + target;
    }
}

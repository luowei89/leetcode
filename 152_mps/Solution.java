public class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int byMin = min * nums[i];
            int byMax = max * nums[i];
            min = min(byMin, byMax, nums[i]);
            max = max(byMin, byMax, nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
    
    private int min(int a, int b, int c) {
        if (a < b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }
    
    private int max(int a, int b, int c) {
        if (a > b) {
            return a > c ? a : c;
        } else {
            return b > c ? b : c;
        }
    }
}

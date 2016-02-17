public class Solution {
    
    // constant space
    public int[] productExceptSelf(int[] nums) {
        // Given n > 1
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int num = 1;
        for (int i = 1; i < n; i++) { 
            num = num * nums[n-i];
            result[n-i-1] = result[n-i-1] * num;
        }
        return result;
    }
    // O(n) space
    // public int[] productExceptSelf(int[] nums) {
    //     // Given n > 1
    //     int n = nums.length;
    //     int[] left = new int[n];
    //     int[] right = new int[n];
    //     left[0] = right[n-1] = 1;
    //     for (int i = 1; i < n; i++) {
    //         left[i] = left[i-1] * nums[i-1];
    //         right[n-i-1] = right[n-i] * nums[n-i];
    //     }
    //     int[] result = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         result[i] = left[i] * right[i];
    //     }
    //     return result;
    // }
}

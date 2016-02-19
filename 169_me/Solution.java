public class Solution {
        
    // Array Sort 3ms
    // public int majorityElement(int[] nums) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     return nums[n/2];
    // }
    
    // Bit Manipulation 31ms
    // public int majorityElement(int[] nums) {
    //     int major = 0, n = nums.length;
    //     for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
    //         int bitCounts = 0;
    //         for (int j = 0; j < n; j++) {
    //             if ((nums[j] & mask) != 0) bitCounts++;
    //             if (bitCounts > n / 2) {
    //                 major |= mask;
    //                 break;
    //             }
    //         }
    //     }
    //     return major;
    // }
    
    // Divide and Conquer 2ms
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    private int majorityElement(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        int left = majorityElement(nums, start, mid);
        int right = majorityElement(nums, mid + 1, end);
        if (left == right) {
            return left;
        }
        int c1 = count(nums, start, mid, left);
        int c2 = count(nums, mid + 1, end, right);
        return c1 > c2 ? left : right;
    }
    
    private int count(int[] nums, int start, int end, int val) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if(nums[i] == val) {
                count++;
            }
        }
        return count;
    }
}

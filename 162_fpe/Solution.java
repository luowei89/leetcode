public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    public int findPeakElement(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, start, mid);
        } else {
            return findPeakElement(nums, mid + 1, end);
        }
    }
}

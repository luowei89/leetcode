public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        // assume that no duplicate exists in the array.
        int index = findMin(nums, 0, nums.length-1);
        return nums[index];
    }
    
    private int findMin(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return start;
        }
        int mid = (start + end) / 2;
        int left = findMin(nums, start, mid);
        int right = findMin(nums, mid+1, end);
        return nums[left] < nums[right] ? left : right;
    }
}

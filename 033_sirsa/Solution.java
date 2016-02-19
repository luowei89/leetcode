public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int target, int start, int end) {
        if (nums[start] == nums[end]) {
            return target == nums[start] ? start : -1;
        } else if (nums[start] < nums[end]) {
            return searchSorted(nums, target, start, end);
        } else { // nums[start] > nums[end]
            int mid = (start + end) / 2;
            int left = search(nums, target, start, mid);
            if (left >= 0) {
                return left;
            } 
            int right = search(nums, target, mid + 1, end);
            return right;
        } 
    }
    
    private int searchSorted(int[] nums, int target, int start, int end) { 
        if(target < nums[start] || target > nums[end]) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchSorted(nums, target, start, mid - 1);
        } else { // target > nums[mid]
            return searchSorted(nums, target, mid + 1, end);
        }
    }
}

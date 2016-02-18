public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }
    
    private int[] searchRange(int[] nums, int target, int start, int end) {
        if (start > end) {
            int[] notFound = {-1, -1};
            return notFound;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return searchRange(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return searchRange(nums, target, mid + 1, end);
        } else {
            int[] range = new int[2];
            range[0] = searchStart(nums, target, start, mid);
            range[1] = searchEnd(nums, target, mid, end);
            return range;
        }
    }
    
    private int searchStart(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return searchStart(nums, target, mid + 1, end);
        } else {
            return searchStart(nums, target, start, mid);
        }
    }
    
    private int searchEnd(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return end;
        }
        int mid = (start + end) / 2 + (start + end) % 2;
        if (nums[mid] > target) {
            return searchEnd(nums, target, start, mid - 1);
        } else {
            return searchEnd(nums, target, mid, end);
        }
    }
}

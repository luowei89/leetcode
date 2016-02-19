public class Solution {
    // for any integer x in [1,n]
    // if count(nums < x) < x , duplicate >= x
    // if count(nums > x) >= n-x, duplicate <= x
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        return findDuplicate(nums, 1, n);
    }
    
    private int findDuplicate(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        int greater = 0;
        int less = 0;
        for (int num : nums) {
            if (num > mid) {
                greater++;
            } else if (num < mid) {
                less++;
            }
        }
        if (greater + less + 1 < nums.length) {
            return mid;
        } else if (less < mid) {
            return findDuplicate(nums, mid + 1, end);
        } else {
            return findDuplicate(nums, start, mid);
        }
    }
}

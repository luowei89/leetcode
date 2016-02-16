public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        // copy
        int[] copy = new int[k];
        for (int i = 0; i < k; i++) {
            copy[i] = nums[n-k+i];
        }
        // move
        for (int i = 0; i < n-k; i++) {
            nums[n-i-1] = nums[n-i-k-1];
        }
        // copy back
        for (int i = 0; i < k; i++) {
            nums[i] = copy[i];
        }
    }
}

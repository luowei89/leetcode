public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int increaseIndex = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                increaseIndex = i - 1;
                break;
            }
        }
        if (increaseIndex != -1) {
            int swapIndex = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[increaseIndex]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(nums, increaseIndex, swapIndex);
        }
        reverse(nums, increaseIndex + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while ( i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

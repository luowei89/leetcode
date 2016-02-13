public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length - 1) {
            if (nums[i] != 0) {
                j++;
            }
            i++;
            nums[j] = nums[i];
        }
        while (j < nums.length - 1) {
            j++;
            nums[j] = 0;
        }
    }
}

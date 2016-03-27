public class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = (nums.length - 1) / 2 , j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (k%2 == 0) {
                nums[k] = copy[i--];
            } else {
                nums[k] = copy[j--];
            }
        }
    }
}

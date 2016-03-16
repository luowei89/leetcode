public class Solution {
    public static final int RED = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;
    public void sortColors(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        int i = 0;
        while (i <= q) {
            switch (nums[i]) {
                case RED :
                    swap(nums, i, p);
                    i++;
                    p++;
                    break;
                case WHITE:
                    i++;
                    break;
                case BLUE:
                    swap(nums, i, q);
                    q--;
                    break;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

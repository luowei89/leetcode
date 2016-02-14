public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int newLength = n;
        int i = 0;
        while(i < newLength) {
            if(nums[i] == val) {
                newLength--;
                nums[i] = nums[newLength];
            } else {
                i++;
            }
        }
        return newLength;
    }
}

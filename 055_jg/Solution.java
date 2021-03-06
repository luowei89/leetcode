public class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex = -1;
        int maxIndex = 0;
        while (maxIndex < nums.length && lastIndex < maxIndex) {
            int start = lastIndex;
            lastIndex = maxIndex;
            int i = maxIndex;
            while (i > start) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
                i--;
            }
        }
        return false;
    }
}

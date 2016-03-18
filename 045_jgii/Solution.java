public class Solution {
    public int jump(int[] nums) {
        int lastIndex = -1;
        int maxIndex = 0;
        int steps = 0;
        while (maxIndex < nums.length - 1) {
            int start = lastIndex;
            lastIndex = maxIndex;
            int i = maxIndex;
            steps++;
            while (i > start) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1) {
                    return steps;
                }
                i--;
            }
        }
        return steps;
    }
}

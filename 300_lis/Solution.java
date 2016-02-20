public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n];
        int longest = 0;
        for (int i = 0; i < n; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lengths[i] = lengths[i] > lengths[j] + 1 ? lengths[i] : lengths[j] + 1;
                }
            }
            if (lengths[i] > longest) {
                longest = lengths[i];
            }
        }
        return longest;
    }
}

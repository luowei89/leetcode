public class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 1;
        int patches = 0;
        int i = 0;
        while (sum <= n) {
            if(i < nums.length && nums[i] <= sum) {
                sum += nums[i];
                i++;
            } else {
                sum += sum;
                patches++;
            }
        }
        return patches;
    }
}

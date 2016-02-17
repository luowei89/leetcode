public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = result^i;
            result = result^nums[i];
        }
        result = result ^ nums.length;
        return result;
    }
}

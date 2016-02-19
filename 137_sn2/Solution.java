public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += nums[i]>>j & 1;
            }
        }
        int number = 0;
        for (int i = 0; i < 32; i++) {
            number <<= 1;
            number += bits[31-i] % 3;
        }
        return number;
    }
}

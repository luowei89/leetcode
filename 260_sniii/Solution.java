public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        int x = xor;
        int n = 0;
        while ((x & 1) != 1) {
            x = x>>1;
            n++;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> n & 1) == 0) {
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }
}

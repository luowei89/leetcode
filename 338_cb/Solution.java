public class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        bits[0] = 0;
        if (num > 0) {
            bits[1] = 1;
        }
        int nextPowerOfTwo = 2;
        int index = 0;
        for (int i = 2; i <= num; i++) {
            if (i == nextPowerOfTwo) {
                index = 0;
                nextPowerOfTwo = nextPowerOfTwo * 2;
            }
            bits[i] = bits[index] + 1;
            index++;
        }
        return bits;
    }
}

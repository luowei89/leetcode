public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        while(n != 0){
            bits += n & 1;
            n = n >> 1;
            if(n < 0){
                n = n ^ (1 << 31);
            }
        }
        return bits;
    }
}
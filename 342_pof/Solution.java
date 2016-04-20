public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && (Math.log(num) / Math.log(2)) % 2 == 0;
    }
}

public class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int threes = n / 3;
        int twos = n % 3;
        if (twos == 2) {
            twos = 1;
        } else if (twos == 1) {
            threes--;
            twos = 2;
        }
        int result = 1;
        while (threes > 0) {
            result = result * 3;
            threes--;
        }
        while (twos > 0) {
            result = result * 2;
            twos--;
        }
        return result;
    }
}

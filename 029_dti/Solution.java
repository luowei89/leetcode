public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        int sign = 1;
        long dividendL = dividend;
        if (dividendL < 0) {
            dividendL = 0 - dividendL;
            sign = 0 - sign;
        }
        long divisorL = divisor;
        if (divisorL < 0) {
            divisorL = 0 - divisorL;
            sign = 0 - sign;
        }
        int countTwo = 0;
        int newCountTwo = countTwo(dividendL, divisorL);
        long newDividend = dividendL;
        while (newCountTwo > 0) {
            countTwo += 1<<newCountTwo;
            if (countTwo < 0) {
                return Integer.MAX_VALUE;
            }
            newDividend = newDividend - (divisorL<<newCountTwo);
            newCountTwo = countTwo(newDividend, divisorL);
        }
        int count = 0;
        long number = divisorL;
        while (number <= newDividend) {
            number += divisorL;
            count++;
        }
        if (sign < 0) {
            return 0 - (countTwo + count);
        } else {
            return countTwo + count;
        }
    }
    private int countTwo(long dividend, long divisor) {
        int countTwo = 0;
        long numberTwo = divisor;
        while (numberTwo <= dividend) {
            numberTwo = numberTwo<<1;
            countTwo++;
        }
        return countTwo-1;
    }
}

public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        if (n == 0) {
            return -1;
        }
        uglyNumbers[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        for (int i = 1; i < n; i++) {
            if (next2 < next3 && next2 < next5) {
                uglyNumbers[i] = next2;
                i2++;
                next2 = uglyNumbers[i2] * 2;
                while (next2 == next3 || next2 == next5) {
                    i2++;
                    next2 = uglyNumbers[i2] * 2;
                }
                if (next2 < 0) {
                    next2 = Integer.MAX_VALUE;
                }
            } else if (next3 < next2 && next3 < next5) {
                uglyNumbers[i] = next3;
                i3++;
                next3 = uglyNumbers[i3] * 3;
                while (next3 == next2 || next3 == next5) {
                    i3++;
                    next3 = uglyNumbers[i3] * 3;
                }
                if (next3 < 0) {
                    next3 = Integer.MAX_VALUE;
                }
            } else if (next5 < next2 && next5 < next3) {
                uglyNumbers[i] = next5;
                i5++;
                next5 = uglyNumbers[i5] * 5;
                while (next5 == next2 || next5 == next3) {
                    i5++;
                    next5 = uglyNumbers[i5] * 5;
                }
                if (next5 < 0) {
                    next5 = Integer.MAX_VALUE;
                }
            }
        }
        return uglyNumbers[n-1];
    }
}

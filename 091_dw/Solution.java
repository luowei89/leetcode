public class Solution {
    // Pay attention to the '0's in "10" and "20"
    // Need to simplify logic
    private static final int TWO_SIX = (2<<5)+6;
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1 && !"0".equals(s)) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int[] numbers = new int[n];
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            numbers[i-zeros] = chars[i] - '0';
            if (numbers[i-zeros] < 0 || numbers[i-zeros] > 9) {
                return 0;
            }
            if (numbers[i-zeros] == 0) {
                if (i-zeros == 0) {
                    return 0;
                }
                if (!(numbers[i-zeros-1] == 1 || numbers[i-zeros-1] == 2)) {
                    return 0;
                }
                numbers[i-zeros-1] = numbers[i-zeros-1] * 10;
                zeros++;
            }

        }
        int[] lastTwoWays = new int[2];
        lastTwoWays[0] = 1;
        int val = (numbers[0]<<5) + numbers[1];
        if (val <= TWO_SIX && numbers[1] != 10 && numbers[1] != 20) {
            lastTwoWays[1] = 2;
        } else {
            lastTwoWays[1] = 1;
        }

        for (int i = 2; i < n - zeros; i++) {
            int value = (numbers[i-1]<<5) + numbers[i];
            int tmp;
            if (value <= TWO_SIX && numbers[i] != 10 && numbers[i] != 20) {
                tmp = lastTwoWays[0] + lastTwoWays[1];
                
            } else {
                tmp = lastTwoWays[1];
            }
            lastTwoWays[0] = lastTwoWays[1];
            lastTwoWays[1] = tmp;
        }
        return lastTwoWays[1] ;
    }
}

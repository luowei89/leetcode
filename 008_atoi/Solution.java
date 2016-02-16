public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        long sum = 0;
        Integer sign = null;
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - '0';
            if (sign == null && chars[i] == '-') {
                sign = -1;
            } else if (sign == null && chars[i] == '+') {
                sign = 1;
            } else if (val >= 0 && val <= 9) {
                sum = sum * 10;
                sum += val;
                if (sum > Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
            } else {
                // not valid after
                break;
            }
        }
        if (sign == null) {
            sign = 1;
        }
        if (sum < 0) {
            // overflow
            sum = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sign = 1;
        }
        return (int)sum * sign;
    }
}

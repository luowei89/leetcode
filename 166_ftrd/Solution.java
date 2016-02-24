public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        if ((long)numerator * (long)denominator < 0) {
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        num = (num % den) * 10;
        Map<Long, Integer> digits = new HashMap<>();
        Map<Integer, Long> reverseDigits = new HashMap<>();
        int i = 0;
        int j = -1;
        while (num > 0) {
            if (digits.containsKey(num)) {
                j = digits.get(num);
                break;
            }
            digits.put(num, i);
            long digit = num / den;
            reverseDigits.put(i, digit);
            i++;
            num = (num % den) * 10;
        }
        if (digits.size() > 0) {
            sb.append(".");
            if (j != -1) {
                for (int x = 0; x < j; x++) {
                    sb.append(reverseDigits.get(x));
                }
                sb.append("(");
                for (int x = j; x < reverseDigits.size(); x++) {
                    sb.append(reverseDigits.get(x));
                }
                sb.append(")");
            } else {
                for (int x = 0; x < reverseDigits.size(); x++) {
                    sb.append(reverseDigits.get(x));
                }
            }
        }
        return sb.toString();
    }
}

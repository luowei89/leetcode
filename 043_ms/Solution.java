public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int m = num1.length();
        int n = num2.length();
        int[] digitsShort, digitsLong;
        int lenShort, lenLong;
        if (m < n) {
            lenShort = m;
            lenLong = n;
            digitsShort = str2Digits(num1);
            digitsLong = str2Digits(num2);
        } else {
            lenShort = n;
            lenLong = m;
            digitsShort = str2Digits(num2);
            digitsLong = str2Digits(num1);            
        }
        
        for (int i = 0; i < lenShort+lenLong-1; i++) {
            for (int j = Math.max(i-lenShort+1, 0); j < Math.min(lenLong, i+1); j++) {
                carry += digitsLong[lenLong-1-j] * digitsShort[lenShort-1-i+j];
            }
            sb.append(carry%10);
            carry = carry/10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    
    private int[] str2Digits(String num) {
        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
        }
        return digits;
    }
}

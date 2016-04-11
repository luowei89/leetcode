public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i < (len + 1) / 2; i++) {
            for (int j = 1; j < (len + 1) / 2; j++) {
                if (isAdditiveNumber(num, j, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isAdditiveNumber(String num, int len1, int len2) {
        if (num.length() <= len1 + len2) {
            return false;
        }
        String num1 = num.substring(0, len1);
        String num2 = num.substring(len1, len1 + len2);
        if ((len1 > 1 && num1.startsWith("0")) || (len2 > 1 && num2.startsWith("0"))) {
            return false;
        }
        String remain = num.substring(len1 + len2);
        while (remain.length() > 0) {
            String next = add(num1, num2);
            if (!remain.startsWith(next)) {
                return false;
            }
            num1 = num2;
            num2 = next;
            remain = remain.substring(next.length());
        }
        return true;
    }
    
    public String add(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

public class Solution {
    public int calculate(String s) {
        StringBuffer num = new StringBuffer();
        int result = 0;
        int mulVal = 1;
        int lastOp = 1;
        boolean mul = true;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (mul) {
                    mulVal = mulVal * Integer.parseInt(num.toString());
                } else {
                    mulVal = mulVal / Integer.parseInt(num.toString());
                }
                num = new StringBuffer();
            }
            if (c == '+' || c == '-') {
                result += lastOp * mulVal;
                lastOp = c == '+' ? 1 : -1;
                mulVal = 1;
                mul = true;
            } else if (c == '*' || c == '/') {
                mul = c == '*';
            } else if (c >= '0' && c <= '9') {
                num.append(c);
            }
        }
        if (mul) {
            mulVal = mulVal * Integer.parseInt(num.toString());
        } else {
            mulVal = mulVal / Integer.parseInt(num.toString());
        }
        result += lastOp * mulVal;
        return result;
    }
}

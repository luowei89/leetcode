public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) {
            return null;
        }
        String lastStr = "1";
        for(int i = 1; i < n; i++) {
            lastStr = countAndSay(lastStr);
        }
        return lastStr;
    }
    
    private String countAndSay(String str){
        int lastDigit = str.charAt(0) - '0';
        int n = str.length();
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n; i++) {
            int digit = str.charAt(i) - '0';
            if(digit == lastDigit) {
                count++;
            } else {
                sb.append(count);
                sb.append(lastDigit);
                count = 1;
                lastDigit = digit;
            }
        }
        sb.append(count);
        sb.append(lastDigit);
        return sb.toString();
    }
}

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        char lastChar;
        if(strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0;;i++) {
            if(strs[0].length() < i+1) {
                return sb.toString();
            }
            lastChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i+1 || strs[j].charAt(i) != lastChar) {
                    return sb.toString();
                }
            }
            sb.append(lastChar);
        }
    }
}

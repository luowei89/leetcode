public class Solution {
    public static final String SPACE = " ";
    public String reverseWords(String s) {
        String[] words = s.split(SPACE);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            if (!"".equals(words[words.length-i-1])) {
                sb.append(words[words.length-i-1]);
                sb.append(SPACE);
            }
        }
        return sb.toString().trim();
    }
}

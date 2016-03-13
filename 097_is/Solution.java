public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        if (len1 == 0 || len2 == 0) {
            return s3.equals(s1+s2);
        }
        boolean[][] results = new boolean[2][len2+1];
        for (int i = 0; i < len2 + 1; i++) {
            results[0][i] = s2.substring(0, i).equals(s3.substring(0,i));
        }
        for (int i = 1; i < len1 + 1; i++) {
            results[i%2][0] = s1.substring(0, i).equals(s3.substring(0,i));;
            for (int j = 1; j < len2 + 1; j++) {
                results[i%2][j] = (results[(i-1)%2][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (results[i%2][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return results[len1%2][len2];
    }
}

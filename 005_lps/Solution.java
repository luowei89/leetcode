public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int max = 0;
        int iMax = 0;
        for ( int win = 0; win < n; win++) {
            for (int i = 0; i + win < n; i++) {
                if (win == 0) {
                    palindrome[i][i] = true;
                } else if (win == 1) {
                    palindrome[i][i+win] = s.charAt(i) == s.charAt(i+win);
                } else {
                    palindrome[i][i+win] = palindrome[i+1][i+win-1] && s.charAt(i) == s.charAt(i+win);
                }
                if (palindrome[i][i+win]) {
                    iMax = i;
                    max = win;
                }
            }
        }
        return s.substring(iMax, iMax+max+1);
    }
}

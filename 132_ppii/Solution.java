public class Solution {
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        boolean[][] palMatrix = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            palMatrix[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                palMatrix[i][j] = (i+1 >= j-1 || palMatrix[i+1][j-1]) && chars[i] == chars[j];
            }
        }
        int mins[] = new int[n];
        for (int i = 0; i < n; i++) {
            mins[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (palMatrix[j][i]) {
                    mins[i] = Math.min(mins[i], j-1 < 0 ? 1 : mins[j-1]+1);
                }
            }
        }
        return mins[n-1]-1;
    }
}

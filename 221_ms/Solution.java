public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] side = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            side[i][0] = matrix[i][0] - '0';
            if (side[i][0] > maxSide) {
                maxSide = side[i][0];
            }
        }
        for (int j = 0; j < n; j++) {
            side[0][j] = matrix[0][j] - '0';
            if (side[0][j] > maxSide) {
                maxSide = side[0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    side[i][j] = min(side[i-1][j-1], side[i-1][j], side[i][j-1]) + 1;
                    if (side[i][j] > maxSide) {
                        maxSide = side[i][j];
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
    
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

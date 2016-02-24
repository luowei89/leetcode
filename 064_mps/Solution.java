public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] sums = new int[n][m];
        sums[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sums[i][0] = sums[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            sums[0][i] = sums[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int oldSum = sums[i-1][j] < sums[i][j-1] ? sums[i-1][j] : sums[i][j-1];
                sums[i][j] = oldSum + grid[i][j];
            }
        }
        return sums[n-1][m-1];
    }
}

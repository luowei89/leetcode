public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m - 1][n - 1] = Math.min(dungeon[m - 1][n - 1], 0);
        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.min(health[i + 1][n - 1] + dungeon[i][n - 1], 0);
        }
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.min(health[m - 1][j + 1] + dungeon[m - 1][j], 0);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                health[i][j] = Math.min(Math.max(health[i + 1][j], health[i][j + 1]) + dungeon[i][j], 0);
            }
        }
        return 1 - health[0][0];
    }
}

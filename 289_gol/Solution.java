public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int next = nextGen(board, i, j);
                board[i][j] += next << 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int nextGen(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int live = 0;
        int dead = 0;
        for (int ii = Math.max(i - 1, 0); ii < Math.min(i + 2, m); ii++) {
            for (int jj = Math.max(j - 1, 0); jj < Math.min(j + 2, n); jj++) {
                if (ii != i || jj != j) {
                    if ((board[ii][jj] & 1) == 1) {
                        live++;
                    } else {
                        dead++;
                    }
                }
            }
        }
        int next = 0;
        if ((live == 2 && (board[i][j] & 1) == 1) || live == 3) {
            next = 1;
        }
        return next;
    }
}

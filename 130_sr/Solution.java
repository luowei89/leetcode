public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        boolean[][] connected = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(i);
                queue.add(0);
                connected[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                queue.add(i);
                queue.add(n - 1);
                connected[i][n - 1] = true;
            }
        }
        for (int i = 1; i < n - 1; i++) {
                if (board[0][i] == 'O') {
                queue.add(0);
                queue.add(i);
                connected[0][i] = true;
            }
            if (board[m - 1][i] == 'O') {
                queue.add(m - 1);
                queue.add(i);
                connected[m - 1][i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            if (x - 1 > 0 && !connected[x - 1][y] && board[x - 1][y] == 'O') {
                queue.add(x - 1);
                queue.add(y);
                connected[x - 1][y] = true;
            }
            if (x + 1 < m - 1 && !connected[x + 1][y] && board[x + 1][y] == 'O') {
                queue.add(x + 1);
                queue.add(y);
                connected[x + 1][y] = true;
            }
            if (y - 1 > 0 && !connected[x][y - 1] && board[x][y - 1] == 'O') {
                queue.add(x);
                queue.add(y - 1);
                connected[x][y - 1] = true;
            }
            if (y + 1 < n - 1 && !connected[x][y + 1] && board[x][y + 1] == 'O') {
                queue.add(x);
                queue.add(y + 1);
                connected[x][y + 1] = true;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!connected[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

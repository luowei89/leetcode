public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        
        if (word == null || word.length() == 0) {
            return false;
        }
        char startChar = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == startChar) {
                    boolean[][] searchboard = new boolean[m][n];
                    if(search(board, word, i, j, 0, searchboard)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int x, int y, int wordIndex, boolean[][] searchboard) {
        int m = board.length;
        int n = board[0].length;
        
        if (board[x][y] != word.charAt(wordIndex)) {
            return false;
        }
        if(wordIndex >= word.length() - 1) {
            return true;
        }
        searchboard[x][y] = true;
        if (x-1 >= 0 && !searchboard[x-1][y]) {
            if(search(board, word, x-1, y, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (x+1 < m && !searchboard[x+1][y]) {
            if(search(board, word, x+1, y, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (y-1 >= 0 && !searchboard[x][y-1]) {
            if(search(board, word, x, y-1, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (y+1 < n && !searchboard[x][y+1]) {
            if(search(board, word, x, y+1, wordIndex+1, searchboard)){
                return true;
            }
        }
        searchboard[x][y] = false;
        return false;
    }
}

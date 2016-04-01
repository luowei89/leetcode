public class Solution {
    public void solveSudoku(char[][] board) {
        Set<Character>[][] possibles = new Set[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    possibles[i][j] = new HashSet<>();
                    for (char c ='1'; c <= '9'; c++) {
                        possibles[i][j].add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    addToBoard(i, j, board[i][j], board, possibles);
                }
            }
        }

        PriorityQueue<Cell> queue = new PriorityQueue<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    queue.add(new Cell(i, j, possibles[i][j]));
                }
            }
        }

        Cell cell = queue.poll();
        tryCell(cell, board, possibles, queue);
    }

    private boolean tryCell(Cell cell, char[][] board, Set<Character>[][] possibles, PriorityQueue<Cell> queue) {
        Set<Character> possible = new HashSet<>(cell.getPossibles());
        for (char c : possible) {
            if (tryCellWith(cell, c, board, possibles, queue)) {
                return true;
            }
        }
        queue.add(cell);
        return false;
    }

    private boolean tryCellWith(Cell cell, char c, char[][] board, Set<Character>[][] possibles, PriorityQueue<Cell> queue) {
        addToBoard(cell.x, cell.y, c, board, possibles);
        if (queue.isEmpty()) {
            return true;
        }
        if (tryCell(queue.poll(), board, possibles, queue)) {
            return true;
        } else {
            removeFromBoard(cell.x, cell.y, board, possibles);
            return false;
        }
    }

    public class Cell implements Comparable<Cell> {
        private int x;
        private int y;
        private Set<Character> possibles;

        public Cell(int x, int y, Set<Character> possibles) {
            this.x = x;
            this.y = y;
            this.possibles = possibles;
        }

        @Override
        public int compareTo(Cell o) {
            return this.possibles.size() - o.possibles.size();
        }

        public Set<Character> getPossibles() {
            return possibles;
        }
    }

    private void addToBoard(int x, int y, char val, char[][] board, Set<Character>[][] possibles) {
        board[x][y] = val;
        int x1 = x / 3;
        int y1 = y / 3;
        for (int i = 0; i < 9; i++) {
            if (possibles[x][i] != null) {
                possibles[x][i].remove(val);
            }
            if (possibles[i][y] != null) {
                possibles[i][y].remove(val);
            }
            int xi = x1 * 3 + i / 3;
            int yi = y1 * 3 + i % 3;
            if (possibles[xi][yi] != null) {
                possibles[xi][yi].remove(val);
            }
        }
    }

    private void removeFromBoard(int x, int y, char[][] board, Set<Character>[][] possibles) {
        int x1 = x / 3;
        int y1 = y / 3;
        char val = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < 9; i++) {
            addPossible(x, i, val, board, possibles);
            addPossible(i, y, val, board, possibles);
            addPossible(x1 * 3 + i / 3, y1 * 3 + i % 3, val, board, possibles);
        }
    }

    private void addPossible(int x, int y, char val, char[][] board, Set<Character>[][] possibles) {
        if (possibles[x][y] != null) {
            int x1 = x / 3;
            int y1 = y / 3;
            for (int i = 0; i < 9; i++) {
                if (board[x][i] == val
                        || board[i][y] == val
                        || board[x1 * 3 + i / 3][y1 * 3 + i % 3] == val) {
                    return;
                }
            }
            possibles[x][y].add(val);
        }
    }
}

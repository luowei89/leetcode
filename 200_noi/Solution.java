public class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        Board board = new Board(grid);
        Point nextPoint = board.nextUnexplored();
        while (nextPoint != null) {
            Stack<Point> stack = new Stack<>();
            stack.push(nextPoint);
            while (!stack.isEmpty()) {
                Point p = stack.pop();
                int x = p.getX();
                int y = p.getY();
                if (grid[x][y] == '1') {
                    if (x - 1 >= 0 && !board.isExplored(x - 1, y)) {
                        stack.push(new Point(x - 1, y));
                    }
                    if (x + 1 < m && !board.isExplored(x + 1, y)) {
                        stack.push(new Point(x + 1, y));
                    }
                    if (y - 1 >= 0 && !board.isExplored(x, y - 1)) {
                        stack.push(new Point(x, y - 1));
                    }
                    if (y + 1 < n && !board.isExplored(x, y + 1)) {
                        stack.push(new Point(x, y + 1));
                    }
                }
                board.explore(x, y);
            }
            islands++;
            nextPoint = board.nextUnexplored();
        }
        return islands;
    }
    
    public class Board {
        private boolean[] explored;
        private Point next;
        private int m;
        private int n;
        
        public Board(char[][] grid) {
            this.m = grid.length;
            this.n = grid[0].length;
            explored = new boolean[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    explored[i * n +j] = grid[i][j] == '0';
                }
            }
            next = new Point(0, 0);
        }
        
        public Point nextUnexplored() {
            int i = next.getX() * n + next.getY();
            while (i < m * n) {
                if(!explored[i]) {
                    next = new Point(i/n, i%n);
                    return next;
                }
                i++;
            }
            return null;
        }
        
        public void explore(int x, int y) {
            explored[x * n + y] = true;
        }
        
        public boolean isExplored(int x, int y) {
            return explored[x * n + y];
        }
    }
    
    public class Point {
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
}

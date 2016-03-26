public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        int[][] lengths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes.add(new Node(matrix[i][j], i, j));
                lengths[i][j] = 1;
            }
        }
        int longest = 0;
        
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int x = node.getX(), y = node.getY();
            int val = node.getVal();
            lengths[x][y] = 1;
            if (x + 1 < matrix.length && matrix[x + 1][y] > val) {
                lengths[x][y] = Math.max(lengths[x + 1][y] + 1, lengths[x][y]);
            }
            if (x - 1 >= 0 && matrix[x - 1][y] > val) {
                lengths[x][y] = Math.max(lengths[x - 1][y] + 1, lengths[x][y]);
            }
            if (y + 1 < matrix[0].length && matrix[x][y + 1] > val) {
                lengths[x][y] = Math.max(lengths[x][y + 1] + 1, lengths[x][y]);
            }
            if (y - 1 >= 0 && matrix[x][y - 1] > val) {
                lengths[x][y] = Math.max(lengths[x][y - 1] + 1, lengths[x][y]);
            }
            if (lengths[x][y] > longest) {
                longest = lengths[x][y];
            }
        }
        return longest;
    }
    
    public class Node implements Comparable {
        private int val;
        private int x;
        private int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    
        @Override
        public int compareTo(Object o) {
            return ((Node) o).getVal() - this.val;
        }
    
        public int getVal() {
            return this.val;
        }
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    }
}

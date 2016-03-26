public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        Queue<Integer> coordinates = new LinkedList<>();
        int[][] lengths = new int[m][n];
        int[][] outlinks = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lengths[i][j] = 1;
                if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
                    outlinks[i][j]++;
                }
                if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                    outlinks[i][j]++;
                }
                if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
                    outlinks[i][j]++;
                }
                if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                    outlinks[i][j]++;
                }
                if (outlinks[i][j] == 0) {
                    coordinates.add(i);
                    coordinates.add(j);
                }
            }
        }
        int longest = 0;
        
        while (!coordinates.isEmpty()) {
            int x = coordinates.poll(), y = coordinates.poll();
            if (x + 1 < m) {
                updateGrid(x, y, x + 1, y, matrix, lengths, outlinks, coordinates);
            }
            if (x - 1 >= 0) {
                updateGrid(x, y, x - 1, y, matrix, lengths, outlinks, coordinates);
            }
            if (y + 1 < n) {
                updateGrid(x, y, x, y + 1, matrix, lengths, outlinks, coordinates);
            }
            if (y - 1 >= 0) {
                updateGrid(x, y, x, y - 1, matrix, lengths, outlinks, coordinates);
            }
            if (lengths[x][y] > longest) {
                longest = lengths[x][y];
            }
        }
        return longest;
    }
    
    public void updateGrid(int x1, int y1, int x2, int y2, int[][] matrix, int[][] lengths, int[][] outlinks, Queue<Integer> coordinates) {
        if (matrix[x2][y2] > matrix[x1][y1]) {
            lengths[x1][y1] = Math.max(lengths[x2][y2] + 1, lengths[x1][y1]);
        } else if (matrix[x2][y2] < matrix[x1][y1]) {
            outlinks[x2][y2]--;
            if (outlinks[x2][y2] == 0) {
                coordinates.add(x2);
                coordinates.add(y2);
            }
        }
    }
}

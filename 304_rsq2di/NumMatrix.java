public class NumMatrix {

    Map<String, Integer> sums;
    public NumMatrix(int[][] matrix) {
        this.sums = new HashMap<>();
        if (matrix.length > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int sum = getSum(i-1, j) + getSum(i, j-1) - getSum(i-1, j-1) + matrix[i][j];
                    putSum(i, j, sum);
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1-1) - getSum(row1-1, col2) + getSum(row1-1, col1-1);
    }
    
    private int getSum(int x, int y) {
        String key = x + "," + y;
        Integer sum = this.sums.get(key);
        return sum == null ? 0 : sum;
    }
    
    private void putSum(int x, int y, int val) {
        String key = x + "," + y;
        this.sums.put(key, val);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

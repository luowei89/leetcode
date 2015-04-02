public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int counter = 0;
        int m = matrix.length;
        if(m == 0){
            return result;
        }
        int n = matrix[0].length;
        if(n == 1){
            for(int i = 0; i < m; i++){
                result.add(matrix[i][0]);
            }
            return result;
        }
        int size = m * n;
        int i = 0;
        int j = 0;
        int level = 0;
        while(counter < size){
            result.add(matrix[j][i]);
            counter++;
            if(j - level == 0 && i + level < n-1){
                i++;
            }
            else if(i + level == n -1 && j + level < m-1){
                j++;
            }
            else if(j + level == m - 1 && i - level > 0){
                i--;
            }
            else if(i - level == 0 && j - level - 1 > 0){
                j--;
            }
            if(i - level == 0 && j - level == 1){
                level++;
            }
        }
        return result;
    }
}
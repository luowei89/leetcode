public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int n = matrix.length;
        while(i < n){
            if(target < matrix[i][0]){
                break;
            }
            i++;
        }
        if(i == 0){
            return false;
        }
        i--;
        for(int j = 0;j < matrix[i].length; j++){
            if(target == matrix[i][j]){
                return true;
            }
        }
        return false;
    }
}
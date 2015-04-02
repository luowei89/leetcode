public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int nSquared = n * n;
        int i = 0;
        int j = 0;
        int level = 0;
        while(num <= nSquared){
            result[j][i] = num++;
            if(j - level == 0 && i + level < n-1){
                i++;
            }
            else if(i + level == n -1 && j + level < n-1){
                j++;
            }
            else if(j + level == n - 1 && i - level > 0){
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
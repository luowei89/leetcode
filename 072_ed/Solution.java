public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] dist = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++){
            dist[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++){
            dist[0][j] = j;
        }
        for(int j = 1; j < n + 1; j++){
            for(int i = 1; i < m + 1; i++){
                dist[i][j] = min(dist[i-1][j]+1,dist[i][j-1]+1,dist[i-1][j-1]+diff(word1.charAt(i-1),word2.charAt(j-1)));
            }
        }
        return dist[m][n];
    }
    
    private int min(int a,int b,int c){
        if(a < b){
            return a < c ? a : c;
        }
        else{
            return b < c ? b : c;
        }
    }
    
    private int diff(char c1, char c2){
        return c1 == c2 ? 0 : 1;
    }
}
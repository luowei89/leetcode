public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        boolean[] flags = new boolean[n];
        for(int i = 0; i < n; i++){
            int value = A[i];
            if(value > 0 && value < n+1){
                flags[value-1] = true;
            }
        }
        for(int i = 0; i < n; i++){
            if(!flags[i]){
                return i+1;
            }
        }
        return n+1;
    }
}
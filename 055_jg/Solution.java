public class Solution {
    public boolean canJump(int[] A) {
        int i = 0;
        int n = A.length;
        while(i < n && A[i] != 0){
            if(i == n - 1){
                return true;
            }
            i += A[i];
        }
        return i >= n - 1;
    }
}
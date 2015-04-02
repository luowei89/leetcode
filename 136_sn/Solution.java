public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for(int i = 0; i < A.length; i++){
            x = x ^ A[i];
        }
        return x;
    }
}
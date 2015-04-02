public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int removed = 0;
        int lastSeen = A[0];
        for(int i = 1; i < n; i++){
            if(A[i] == lastSeen){
                removed++;
            }
            else{
                lastSeen = A[i];
                A[i-removed] = A[i];
            }
        }
        return n-removed;
    }
}
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i = m-1; i >= 0; i--){
            A[n+i] = A[i];
        }
        int index = 0;
        int ia = n;
        int ib = 0;
        while(ia < m+n && ib < n){
            if(A[ia] <= B[ib]){
                A[index] = A[ia];
                ia++;
            }
            else{
                A[index] = B[ib];
                ib++;
            }
            index++;
        }
        while(ib < n){
            A[index] = B[ib];
            ib++;
            index++;
        }
    }
}
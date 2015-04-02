public class Solution {
    public void sortColors(int[] A) {
        int[] flags = new int[3];
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                A[flags[2]]=2;
                A[flags[1]]=1;
                A[flags[0]]=0;
                flags[0]++;
                flags[1]++;
                flags[2]++;
            }
            else if(A[i] == 1){
                A[flags[2]]=2;
                A[flags[1]]=1;
                flags[1]++;
                flags[2]++;
            }
            else if(A[i] == 2){
                A[flags[2]]=2;
                flags[2]++;
            }
        }
    }
}
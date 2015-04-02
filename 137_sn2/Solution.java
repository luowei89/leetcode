public class Solution {
    public int singleNumber(int[] A) {
        int[] counts = new int[32];
        int answer = 0;
        for(int i = 0; i < 32; i++){
            counts[i] = 0;
        }
        for(int i = 0; i < A.length; i++){
            int num = A[i];
            for(int j = 0; j < 32; j++){
                counts[j] += num>>j&1;
            }
        }
        for(int i = 0; i < 32; i++){
            answer += counts[i]%3<<i;
        }
        return answer;
    }
}
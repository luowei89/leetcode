public class Solution {
    public int rob(int[] num) {
        int n = num.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return num[0];
        }
        num[1] = Math.max(num[0],num[1]);
        if(n == 2){
            return num[1];
        }
        for(int i = 2; i < n; i++){
            num[i] = Math.max(num[i-1],num[i]+num[i-2]);
        }
        return num[n-1];
    }
}
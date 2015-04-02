public class Solution {
    public int climbStairs(int n) {
        
        if(n < 3){
            return n;
        }
        
        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i < n+1; i++){
            steps[i] = steps[i-1]+steps[i-2];
        }
        return steps[n];
    }
}
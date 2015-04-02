public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }
        int answer = 0;
        while(x != 0){
            answer = answer*10+x%10;
            x = x/10;
        }
        if(negative){
            answer = -answer;
        }
        return answer;
    }
}
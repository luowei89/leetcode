public class Solution {
    public int romanToInt(String s) {
        //Input is guaranteed to be within the range from 1 to 3999.
        char[] ones = {'I','X','C','M','-'};
        char[] fives = {'V','L','D','-'};
        int[] digits = new int[4];
        int sIndex = 0;
        int dIndex = 3;
        int answer = 0;

        while(sIndex < s.length()){
            char c = s.charAt(sIndex);
            if(c == ones[dIndex]){
                digits[dIndex] += 1;
                sIndex++;
            }
            else if(c == fives[dIndex]){
                if(digits[dIndex] == 0){
                    digits[dIndex] = 5;
                }
                else{
                    //digits[dIndex] == 1
                    digits[dIndex] = 4;
                }
                sIndex++;
            }
            else if(c == ones[dIndex+1]){
                //digits[dIndex] == 1
                digits[dIndex] = 9;
                sIndex++;
            }
            else{
                dIndex--;
            }
        }

        for(int i = 3; i >= 0; i--){
            answer = answer*10+digits[i];
        }
        return answer;
    }
}
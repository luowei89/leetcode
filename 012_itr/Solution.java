public class Solution {
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        //Input is guaranteed to be within the range from 1 to 3999.
        char[] ones = {'I','X','C','M'};
        char[] fives = {'V','L','D',' '};
        int[] digits = new int[4];
        for(int i = 0; i < 4; i++){
            digits[i] = num%10;
            num = num /10;
        }
        for(int i = 3; i >= 0; i--){
            int digit = digits[i];
            if(digit > 0 && digit < 4){
                for(int j = 0; j < digit; j++){
                    roman.append(ones[i]);
                }
            }
            else if(digit == 4){
                roman.append(ones[i]);
                roman.append(fives[i]);
            }
            else if(digit > 4 && digit < 9){
                roman.append(fives[i]);
                for(int j = 5; j < digit; j++){
                    roman.append(ones[i]);
                }
            }
            else if(digit == 9){
                roman.append(ones[i]);
                roman.append(ones[i+1]);
            }
        }
        return roman.toString();
    }
}
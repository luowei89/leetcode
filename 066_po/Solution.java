public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        while(i >= 0){
            digits[i] += 1;
            if(digits[i] < 10){
                break;
            }
            digits[i] = 0;
            i--;
        }
        if(digits[0] == 0 && i == -1){
            int[] plusOne = new int[n+1];
            plusOne[0] = 1;
            for(int j = 0; j < n; j++){
                plusOne[j+1] = digits[j];
            }
            return plusOne;
        }
        return digits;
    }
}
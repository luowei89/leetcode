public class Solution {
    public boolean isPalindrome(String s) {
        int index = 0;
        int n = s.length();
        int[] chars= new int[n];
        for(int i = 0; i < n; i++){
            char c =s.charAt(i);
            if((c >= 'a' && c <= 'z')||(c >= '0' && c <= '9')){
                chars[index] = c;
                index++;
            }
            else if(c >= 'A' && c <= 'Z'){
                chars[index] = c - 'A' + 'a';
                index++;
            }
        }
        for(int i = 0; i < index - i - 1; i++){
            if(chars[i] != chars[index-i-1]){
                return false;
            }
        }
        return true;
    }
}
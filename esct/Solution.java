public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            sb.insert(0,(char)('A'+(n-1)%26));
            n = n%26 == 0? (n-1)/26 : n/26;
        }
        return sb.toString();
    }
}
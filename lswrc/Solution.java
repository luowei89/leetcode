public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<Character>();
        int head = 0;
        int tail = 0;
        int len = s.length();
        int longest = 0;
        while(tail < len){
            char c = s.charAt(tail);
            if(seen.contains(c)){
                longest = longest < tail - head ? tail - head : longest;
                while(seen.contains(c)){
                    char hc = s.charAt(head);
                    seen.remove(hc);
                    head++;
                }
            } else {
                seen.add(c);
                tail++;
            }
        }
        longest = longest < seen.size() ? seen.size() : longest;
        return longest;
    }
}
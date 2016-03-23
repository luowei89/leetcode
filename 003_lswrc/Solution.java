public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Map<Character, Integer> positions = new HashMap<>();
        int maxLength = 0;
        while (j < s.length()) {
            Integer pos = positions.get(s.charAt(j));
            if (pos != null){
                while (i <= pos) {
                    positions.put(s.charAt(i), null);
                    i++;
                }
            } 
            positions.put(s.charAt(j), j);
            j++;
            if (j - i > maxLength) {
                maxLength = j - i;
            }
        }
        return maxLength;
    }
}

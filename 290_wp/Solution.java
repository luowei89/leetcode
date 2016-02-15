public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // assume pattern contains only lowercase letters, 
        // and str contains lowercase letters separated by a single space.
        char[] pats = pattern.toCharArray();
        String[] strs = str.split(" ");
        int n = pats.length;
        if (strs.length != n) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(pats[i]) && !map.get(pats[i]).equals(strs[i])) {
                return false;
            }
            if(map.get(pats[i]) == null && map.containsValue(strs[i])) {
                return false;
            }
            map.put(pats[i], strs[i]);
        }
        return true;
    }
}

public class Solution {
    // 62ms
    // public boolean isIsomorphic(String s, String t) {
    //     Map<Character, Character> mapS = new HashMap<>();
    //     Map<Character, Character> mapT = new HashMap<>();
    //     //assume both s and t have the same length.
    //     for (int i = 0; i < s.length(); i++) {
    //         char cs = s.charAt(i);
    //         char ct = t.charAt(i);
    //         if(mapS.containsKey(cs) && (mapS.get(cs) != ct)) {
    //             return false;
    //         }
    //         if(mapT.containsKey(ct) && (mapT.get(ct) != cs)) {
    //             return false;
    //         }
    //         mapS.put(cs, ct);
    //         mapT.put(ct, cs);
    //     }
    //     return true;
    // }
    // 43ms
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        //assume both s and t have the same length.
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs) && (map.get(cs) != ct)) {
                return false;
            }
            if(map.get(cs) == null && map.containsValue(ct)) {
                return false;
            }
            map.put(cs, ct);
        }
        return true;
    }
}

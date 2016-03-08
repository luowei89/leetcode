public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        Arrays.sort(strs);
        for (String str : strs) {
            int[] code = new int[26];
            for (char c : str.toCharArray()) {
                code[c - 'a']++;
            }
            String key = codeToKey(code);
            List<String> list = result.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            result.put(key, list);
        }
        List<List<String>> resultList = new ArrayList<>();
        for (List<String> list : result.values()) {
            resultList.add(list);
        }
        return resultList;
    }
    
    private String codeToKey(int[] code) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            if (code[i] > 0) {
                sb.append((char)(i+'a'));
                sb.append(code[i]);
            }
        }
        return sb.toString();
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int n = s.length();
        indexes.add(0);
        for(int i = 1; i < n+1; i++){
            for(int index : indexes){
                String str = s.substring(index,i);
                if(dict.contains(str)){
                    indexes.add(i);
                    break;
                }
            }
        }
        return indexes.contains(n);
    }
}
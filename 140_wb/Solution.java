public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<Integer,ArrayList<String>> map;
        map = new HashMap<Integer,ArrayList<String>>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int n = s.length();
        map.put(0,null);
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
        if(indexes.contains(n)){
            for(int i = 1; i < n+1; i++){
                ArrayList<String> newStrs = new ArrayList<String>();
                for(int index : map.keySet()){
                    String str = s.substring(index,i);
                    if(dict.contains(str)){
                        ArrayList<String> bases = map.get(index);
                        if(bases != null){
                            for(String b : bases){
                                newStrs.add(b + " " + str);
                            }
                        }
                        else{
                            newStrs.add(str);
                        }
                    }
                }
                map.put(i,newStrs);
            }
            return map.get(n);
        }
        else{
            return new ArrayList<String>();
        }
    }
}
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int n = dict.size();
        int m = start.length();
        String[] queue = new String[n];
        int[] depths = new int[n];
        int length = 1;
        int head = 0;
        int tail = 0;
        String current = start;
        while(head <= tail){
            char[] cs = current.toCharArray();
            for(int i = 0; i < m; i++){
                char temp = cs[i];
                for(char j = 'a'; j <= 'z'; j++){
                    if(j != cs[i]){
                        cs[i] = j;
                        String str = new String(cs);
                        if(str.equals(end)){
                            return length + 1;
                        }
                        else if(dict.contains(str)){
                            queue[tail] = str;
                            depths[tail] = length + 1;
                            tail++;
                            dict.remove(str);
                        }
                    }
                }
                cs[i] = temp;
            }
            current = queue[head];
            length = depths[head];
            head++;
        }
        return 0;
    }
}
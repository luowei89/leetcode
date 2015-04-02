public class Solution {
    public int longestConsecutive(int[] num) {
        Hashtable<Integer,Integer> nums = new Hashtable<Integer,Integer>();
        for(int i = 0; i < num.length; i++){
            nums.put(num[i],1);
        }
        Hashtable<Integer,Boolean> removed = new Hashtable<Integer,Boolean>();
        for(int key : nums.keySet()){
            if(!removed.containsKey(key)){
                int length = nums.get(key);
                int i = key + length;
                while(nums.containsKey(i)){
                    int l = nums.get(i);
                    removed.put(i,true);
                    length += l;
                    i += l;
                }
            nums.put(key,length);
            }
        }
        int max = 0;
        for(int key : nums.keySet()){
            if(!removed.containsKey(key)){
                int length = nums.get(key);
                if(length > max){
                    max = length;
                }
            }
        }
        return max;
    }
}
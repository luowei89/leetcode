public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++){
            result = insertN(num[i],result);
        }
        return result;
    }
    private ArrayList<ArrayList<Integer>> insertN(int n, ArrayList<ArrayList<Integer>> list){
        Hashtable<ArrayList<Integer>,Boolean> table = new Hashtable<ArrayList<Integer>,Boolean>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(list.isEmpty()){
            ArrayList<Integer> newNums = new ArrayList<Integer>();
            newNums.add(n);
            table.put(newNums,true);
        }
        for(ArrayList<Integer> nums : list){
            for(int i = 0; i < nums.size() + 1; i++){
                ArrayList<Integer> newNums = new ArrayList<Integer>(nums);
                newNums.add(i,n);
                table.put(newNums,true);
            }
        }
        for(ArrayList<Integer> al : table.keySet()){
           result.add(al); 
        }
        return result;
    }
}
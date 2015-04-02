import java.util.*;
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for(int i = 0; i < n; i++){
            candies[i] = 1;
        }
        
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> array;
            int num = ratings[i];
            if(map.containsKey(num)){
                array = map.get(num);
            }
            else{
                array = new ArrayList<Integer>();
            }
            array.add(i);
            map.put(ratings[i],array);
        }
        for(int i : map.keySet()){
            for(int j : map.get(i)){
                if(j > 0 && ratings[j-1]>ratings[j]){
                    candies[j-1] = Math.max(candies[j-1],candies[j] + 1);
                }
                if(j < n-1 && ratings[j+1]>ratings[j]){
                    candies[j+1] = Math.max(candies[j+1],candies[j] + 1);
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += candies[i];
        }
        return sum;
    }
}
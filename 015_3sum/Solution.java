public class Solution {
public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i < num.length;i++){
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                int sum = num[i]+num[j]+num[k];
                if(sum ==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    j++;
                    k--;
                    while(j < k && num[k+1]==num[k]){
                        k--;
                    }
                    while(j < k && num[j-1]==num[j]){
                        j++;
                    }
                } else if (sum > 0){
                    k--;
                    while(j < k && num[k+1]==num[k]){
                        k--;
                    }
                } else {
                    j++;
                    while(j < k && num[j-1]==num[j]){
                        j++;
                    }
                }
            }
            while(i < num.length - 1 && num[i] == num[i+1]){
                i++;
            }
        }
        return result;
    }
}
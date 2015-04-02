public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //map<number,index>
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] answer = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int num = target-numbers[i];
            if(map.containsKey(num)){
                answer[0] = map.get(num);
                answer[1] = i+1;
                return answer;
            }
            else{
                map.put(numbers[i],i+1);
            }
        }
        return answer;
    }
}
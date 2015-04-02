public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int j = gas.length - 1;
        int sum = 0;
        while(i <= j){
            if(sum >= 0){
                sum += gas[i];
                sum -= cost[i];
                i++;
            }
            else{
                sum += gas[j];
                sum -= cost[j];
                j--;
            }
        }
        if(sum >= 0){
            return i%gas.length;
        }
        else{
            return -1;
        }
    }
}
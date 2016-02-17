public class Solution {
    public int bulbSwitch(int n) {
        int i = 1;
        while(i*i <= n) {
            i++;
        }
        return i-1;
    }
    // Time Limit Exceeded 
    // public int bulbSwitch(int n) {
    //     // O(n^2)
    //     int[] result = new int[n];
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if ((j+1)%(i+1) == 0) {
    //                 result[j]++;
    //             }
    //         }
    //     }
    //     int sum = 0;
    //     for(int x : result) {
    //         sum += x%2;
    //     }
    //     return sum;
    // }
}

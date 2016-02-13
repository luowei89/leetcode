public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] uglyFactors = {2, 3, 5};
        for (int u : uglyFactors) {
            while(num % u == 0) {
                num = num / u;
            }
        }
        return num == 1;
    }
}

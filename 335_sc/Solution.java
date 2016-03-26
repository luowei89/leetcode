public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n < 4) {
            return false;
        }
        int i = 2;
        while (i < n && x[i] > x[i-2]) {
            i++;
        }
        if (i == n) {
            return false;
        }
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) 
          ||(i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        return false;
    }
}

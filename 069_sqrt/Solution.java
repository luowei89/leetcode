public class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high;
    }
}

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer a = null;
        Integer b = null;
        for (int n : nums) {
            if (a == null || a >= n) {
                a = n;
            } else if (b == null || b >= n) {
                b = n;
            } else {
                return true;
            }
        }
        return false;
    }
}

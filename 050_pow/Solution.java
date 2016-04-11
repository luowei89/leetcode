public class Solution {
    public double myPow(double x, int n) {
        boolean neg = false;
        if (n < 0) {
            n = 0 - n;
            neg = true;
        }
        double pow = myPowHelper(x, n);
        return neg? 1 / pow : pow;
    }
    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        int half = n / 2;
        double pow = myPow(x, half);
        pow = pow * pow;
        if (n % 2 == 1) {
            pow = pow * x;
        }
        return pow;
    }
}

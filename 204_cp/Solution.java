public class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i; i * j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}

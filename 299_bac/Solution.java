public class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        // assume that the secret and guess only contain digits,
        // and their lengths are always equal.
        int n = secret.length();
        int[] counter = new int[10];
        for(int i = 0; i < n; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                a++;
            } else {
                counter[s]++;
            }
        }
        for (int i = 0; i < n; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s != g && counter[g] > 0) {
                b++;
                counter[g]--;
            }
        }
        return a+"A"+b+"B";
    }
}

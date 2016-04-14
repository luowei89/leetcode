public class Solution {
    public int numSquares(int n) {
        int[] sqs = new int[n + 1];
        sqs[0] = 0;
        sqs[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (sqs[i - j * j] < min) {
                    min = sqs[i - j * j];
                }
            }
            sqs[i] = min + 1;
        }
        return sqs[n];
    }
}

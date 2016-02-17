public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mark = new int[words.length];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mark[i] = mark[i] | (1 << (c-'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mark[i] & mark[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    if (prod  > max) {
                        max = prod;
                    }
                }
            }
        }
        return max;
    }
}

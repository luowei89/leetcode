public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] nFactorial = new int[n];
        nFactorial[0] = 1;
        list.add(1);
        for (int i = 1; i < n; i++) {
            list.add(i+1);
            nFactorial[i] = (i+1) * nFactorial[i-1];
        }
        StringBuffer sb = new StringBuffer();
        k--;
        for (int i = n - 2; i >= 0; i--) {
            sb.append(list.remove(k/nFactorial[i]));
            k = k % nFactorial[i];
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}

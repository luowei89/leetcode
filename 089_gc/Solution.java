public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        for (int i = 0; i < n; i++) {
            int m = grayCode.size();
            for (int j = m-1; j >= 0; j--) {
                grayCode.add(grayCode.get(j) + (1<<i));
            }
        }
        return grayCode;
    }
}

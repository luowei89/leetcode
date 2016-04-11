public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] mins = new int[n];
        mins[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);
            int temp = mins[0] + row.get(0);
            for (int j = 1; j < i; j++) {
                int newj = Math.min(mins[j - 1], mins[j]) + row.get(j);
                mins[j - 1] = temp;
                temp = newj;
            }
            if (i > 0) {
                mins[i] = mins[i - 1] + row.get(i);
                mins[i - 1] = temp;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : mins) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
}

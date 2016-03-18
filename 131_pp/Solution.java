public class Solution {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        boolean[][] palMatrix = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            palMatrix[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                palMatrix[i][j] = (i+1 >= j-1 || palMatrix[i+1][j-1]) && chars[i] == chars[j];
            }
        }
        return partition(s, 0, n-1, palMatrix);
    }
    
    private List<List<String>> partition(String s, int i, int j, boolean[][] palMatrix) {
        List<List<String>> result = new ArrayList<>();
        for (int k = i; k < j; k++) {
            if (palMatrix[i][k]) {
                String s1 = s.substring(i, k+1);
                List<List<String>> rest = partition(s, k+1, j, palMatrix);
                for (List<String> restItem : rest) {
                    List<String> list = new ArrayList<>();
                    list.add(s1);
                    list.addAll(restItem);
                    result.add(list);
                }
            }
        }
        if (palMatrix[i][j]) {
            List<String> list = new ArrayList<>();
            list.add(s.substring(i, j+1));
            result.add(list);
        }
        return result;
    }
}

public class Solution {
    
    private static final int[] candidates = {1,2,3,4,5,6,7,8,9};
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        find(k, n, -1, 0, path, result);
        return result;
    }
    
    private void find(int k, int n, int index, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum == n && path.size() == k) {
            result.add(path);
        } else if (sum < n && path.size() < k) {
            for (int i = index + 1; i < candidates.length; i++) {
                int newSum = sum + candidates[i];
                List<Integer> newPath = new ArrayList(path);
                newPath.add(candidates[i]);
                find(k, n, i, newSum, newPath, result);
            }
        }
    }
}

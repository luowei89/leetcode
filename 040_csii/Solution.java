public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        find(candidates, -1, target, 0, path, result);
        return result;
    }
    
    private void find(int[] candidates, int index, int target, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum < target) {
            int lastCandidate = -1;
            for (int i = index + 1; i < candidates.length; i++) {
                if (candidates[i] != lastCandidate) {
                    int newSum = sum + candidates[i];
                    List<Integer> newPath = new ArrayList(path);
                    newPath.add(candidates[i]);
                    find(candidates, i, target, newSum, newPath, result);
                    lastCandidate = candidates[i];
                }
            }
        } else if (sum == target) {
            result.add(path);
        }
    }
}

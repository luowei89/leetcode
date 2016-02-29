public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        find(candidates, 0, target, 0, path, result);
        return result;
    }
    
    private void find(int[] candidates, int index, int target, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                int newSum = sum + candidates[i];
                List<Integer> newPath = new ArrayList(path);
                newPath.add(candidates[i]);
                find(candidates, i, target, newSum, newPath, result);
            }
        } else if (sum == target) {
            result.add(path);
        }
    }
}

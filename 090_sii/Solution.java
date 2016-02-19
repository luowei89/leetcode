public class Solution {
    // Add One each Time
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        Arrays.sort(nums);
        int n = nums.length;
        int lastSize = 1;
        for(int i = 0; i < n; i++) {
            int currentResults = result.size();
            for (int j = 0; j < currentResults; j++) {
                if(j == 0 && i > 0 && (nums[i] == nums[i-1])) {
                    j += lastSize;
                }
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
            lastSize = currentResults;
        }
        return result;
    }
}

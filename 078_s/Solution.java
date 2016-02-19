public class Solution {
    
    // Add One each Time
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int currentResults = result.size();
            for (int j = 0; j < currentResults; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
    // Bit Manipulation
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     int N = 1 << n; // N lists
    //     for (int i = 0; i < N; i++) {
    //         List<Integer> list = new ArrayList();
    //         for (int j = 0; j < n; j++) {
    //             if ((i & (1<<j)) > 0) {
    //                 list.add(nums[j]);
    //             }
    //         }
    //         result.add(list);
    //     }
    //     return result;
    // }
}

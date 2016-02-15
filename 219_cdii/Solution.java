public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    // Time Limit Exceeded
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     int n = nums.length;
    //     for (int i = 0; i < n - k; i++) {
    //         for (int j = i + 1; j <= i + k; j ++) {
    //             if (nums[i] == nums[j]) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}

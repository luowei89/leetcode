public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return result;
        }
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = n-1; j > i+2; j--) {
                if (j < n-1 && nums[j] == nums[j+1]) {
                    continue;
                }
                int p = i+1;
                int q = j-1;
                while (p < q) {
                    int diff = nums[i] + nums[p] + nums[q]+ nums[j] - target;
                    int numsP = nums[p];
                    int numsQ = nums[q];
                    if (diff == 0) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        list.add(nums[j]);
                        result.add(list);
                        while (p < q && numsP == nums[p]) {
                            p++;
                        }
                        while (p < q && numsQ == nums[q]) {
                            q--;
                        }
                    } else if (diff < 0) {
                        while (p < q && numsP == nums[p]) {
                            p++;
                        }
                    } else {
                        while (p < q && numsQ == nums[q]) {
                            q--;
                        }
                    }
                }
            }
        }
        return result;
    }
}

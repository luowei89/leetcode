public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        return combine(nums, k);
    }
    
    public List<List<Integer>> combine(List<Integer> nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k == 0) {
            return list;
        }
        if (k == 1) {
            for (int x : nums) {
                List<Integer> listx = new ArrayList<>();
                listx.add(x);
                list.add(listx);
            }
            return list;
        }
        List<Integer> numsCopy = new ArrayList(nums);
        while (numsCopy.size() > 0) {
            int num = numsCopy.get(0);
            numsCopy.remove(0);
            List<List<Integer>> rest = combine(numsCopy, k - 1);
            for (List<Integer> ls : rest) {
                ls.add(0, num);
            }
            list.addAll(rest);
        }
        return list;
    }
}

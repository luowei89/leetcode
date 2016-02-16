public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int range = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == start + range + 1) {
                range++;
            } else {
                if (range == 0) {
                    result.add(""+start);
                } else {
                    result.add(start+"->"+(start+range));
                    range = 0;
                }
                start = nums[i];
            }
        }
        if (range == 0) {
            result.add(""+start);
        } else {
            result.add(start+"->"+(start+range));
        }
        return result;
    }
}

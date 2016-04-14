public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] counts = new int[2];
        int[] majorities = new int[2];
        majorities[0] = Integer.MAX_VALUE;
        majorities[1] = Integer.MAX_VALUE;
        for (int n : nums) {
            if (majorities[0] != n && majorities[1] != n) {
                if (counts[0] == 0) {
                    majorities[0] = n;
                } else if (counts[1] == 0) {
                    majorities[1] = n;
                }
            }
            if (majorities[0] == n) {
                counts[0]++;
            } else if (majorities[1] == n) {
                counts[1]++;
            } else {
                counts[0]--;
                counts[1]--;
            }
        }
        counts[0] = 0;
        counts[1] = 0;
        for (int n : nums) {
            if (majorities[0] == n) {
                counts[0]++;
            } else if (majorities[1] == n) {
                counts[1]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (counts[i] > nums.length / 3) {
                result.add(majorities[i]);
            }
        }
        return result;
    }
}

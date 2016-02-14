public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastLevelList = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(1);
            int mid = i%2==0 ? (i+1)/2+1 : (i+1)/2;
            for (int j = 1; j < mid; j++) {
                int val = lastLevelList.get(j-1) + lastLevelList.get(j);
                levelList.add(val);
            }
            for (int j = mid; j < i+1; j++) {
                levelList.add(levelList.get(i-j));
            }
            lastLevelList = levelList;
            result.add(levelList);
        }
        return result;
    }
}

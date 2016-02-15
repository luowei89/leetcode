public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = null;
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i/2; j++) {
                int val = lastRow.get(j-1) + lastRow.get(j);
                row.add(val);
            }
            for (int j = i/2 + 1; j < i+1; j++) {
                row.add(row.get(i-j));
            }
            lastRow = row;
        }
        return lastRow;
    }
}

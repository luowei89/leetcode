public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length > 0 && citations[0] >= citations.length) {
            return citations.length;
        }
        for (int i = 1; i < citations.length; i++) {
            if (citations[citations.length - i] >= i && citations[citations.length - i - 1] <= i) {
                return i;
            }
        }
        return 0;
    }
}

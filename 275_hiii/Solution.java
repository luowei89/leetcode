public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;

        int low = 0, high = len - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (len - mid > citations[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return len - low;
    }
}

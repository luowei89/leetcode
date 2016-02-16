/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // assume we have bad version exist
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }
    
    private int firstBadVersion(int from, int to) {
        if (from == to) {
            return from;
        }
        // overflow
        // int mid = (from + to) / 2;
        int mid = (int)(((long)from + (long)to) / 2);
        if(isBadVersion(mid)) {
            return firstBadVersion(from, mid);
        } else {
            return firstBadVersion(mid+1, to);
        }
    }
}

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int len = v1s.length < v2s.length ? v1s.length : v2s.length;
        for (int i = 0; i < len; i++) {
            int v1 = Integer.valueOf(v1s[i]);
            int v2 = Integer.valueOf(v2s[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        int subVers = 0;
        if (v1s.length > v2s.length) {
            for (int i = v2s.length; i < v1s.length; i++) {
                if (Integer.valueOf(v1s[i]) > 0) {
                    return 1;
                }
            }
        } else if (v1s.length < v2s.length) {
            for (int i = v1s.length; i < v2s.length; i++) {
                if (Integer.valueOf(v2s[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

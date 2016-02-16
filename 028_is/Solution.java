public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        char[] haystackCs = haystack.toCharArray();
        char[] needleCs = needle.toCharArray();
        if(needleCs.length == 0) {
            return 0;
        }
        for(int i = 0; i < haystackCs.length - needleCs.length + 1; i++) {
            for (int j = 0; j < needleCs.length; j++) {
                if (haystackCs[i+j] != needleCs[j]) {
                    break;
                }
                if (j == needleCs.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

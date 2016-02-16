public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) {
            return s;
        }
        char[] ss = s.toCharArray();
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }
        int groupCount = 2 * numRows - 2;
        for (int i = 0;  i < ss.length; i++) {
            int memInGroup = i % groupCount;
            if (memInGroup < numRows) {
                sbs[memInGroup].append(ss[i]);
            } else {
                sbs[2*numRows-memInGroup-2].append(ss[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer str : sbs) {
            sb.append(str);
        }
        return sb.toString();
    }
}

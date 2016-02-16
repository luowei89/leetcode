public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int len = lenA > lenB ? lenA + 1 : lenB + 1;
        int[] resultInt = new int[len];
        // O(lenA)
        for (int i = 0; i < lenA; i++) {
            int val = a.charAt(i) - '0';
            if (val != 0 && val != 1) {
                throw new IllegalArgumentException();
            }
            resultInt[i + len - lenA] += val;
        }
        // O(lenB)
        for (int i = 0; i < lenB; i++) {
            int val = b.charAt(i) - '0';
            if (val != 0 && val != 1) {
                throw new IllegalArgumentException();
            }
            resultInt[i + len - lenB] += val;
        }
        // O(len)
        for (int i = 0; i < len; i++) {
            if (resultInt[len - i -1] > 1) {
                resultInt[len - i -1] = resultInt[len - i -1] % 2;
                resultInt[len - i -2] += 1;
            }
        }
        // O(len)
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < len && resultInt[i] == 0) {
            i++;
        }
        for (;i < len; i++) {
            sb.append(resultInt[i]);
        }
        if(sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }
}

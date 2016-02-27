package com.self.leetcode;

import java.util.*;

/**
 * Created by luowei on 2/12/16.
 */
public class LeetCode {

    // 107. Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int depth = reaverseTree(root, levelMap, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (;depth >= 0; --depth) {
            result.add(levelMap.get(depth));
        }
        return result;
    }

    private int reaverseTree(TreeNode root, Map<Integer, List<Integer>> levelMap, int depth) {
        if (root == null) {
            return depth;
        }
        List<Integer> currentList = levelMap.get(depth);
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        int leftDepth = reaverseTree(root.left, levelMap, depth+1);
        int rightDepth = reaverseTree(root.right, levelMap, depth+1);
        currentList.add(root.val);
        levelMap.put(depth, currentList);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    // 223. Rectangle Area
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlayArea = overlayArea(A, B, C, D, E, F, G, H);
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        return area1 + area2 - overlayArea;
    }

    private int overlayArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlayX = overlay(A, C, E, G);
        int overlayY = overlay(B, D, F, H);
        return overlayX * overlayY;
    }

    private int overlay(int A, int C, int E, int G) {
        if (C < E || G < A) {
            return 0;
        }
        int ac = C - A;
        int eg = G - E;
        int left = A < E ? A : E;
        int right = C > G ? C : G;
        return ac + eg - (right - left);
    }

    // 38. Count and Say
    public String countAndSay(int n) {
        if(n <= 0) {
            return null;
        }
        String lastStr = "1";
        for(int i = 1; i < n; i++) {
            lastStr = countAndSay(lastStr);
        }
        return lastStr;
    }

    private String countAndSay(String str){
        int lastDigit = str.charAt(0) - '0';
        int n = str.length();
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n; i++) {
            int digit = str.charAt(i) - '0';
            if(digit == lastDigit) {
                count++;
            } else {
                sb.append(count);
                sb.append(lastDigit);
                count = 1;
                lastDigit = digit;
            }
        }
        sb.append(count);
        sb.append(lastDigit);
        return sb.toString();
    }

    // 290. Word Pattern
    public boolean wordPattern(String pattern, String str) {
        // assume pattern contains only lowercase letters,
        // and str contains lowercase letters separated by a single space.
        char[] pats = pattern.toCharArray();
        String[] strs = str.split(" ");
        int n = pats.length;
        if (strs.length != n) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(pats[i]) && !map.get(pats[i]).equals(strs[i])) {
                return false;
            }
            if(map.get(pats[i]) == null && map.containsValue(strs[i])) {
                return false;
            }
            map.put(pats[i], strs[i]);
        }
        return true;
    }

    // 28. Implement strStr()
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

    // 278. First Bad Version
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }

    private int firstBadVersion(int from, int to) {
        if (from == to) {
            return from;
        }
        int mid = (int)(((long)from + (long)to) / 2);
        if(isBadVersion(mid)) {
            return firstBadVersion(from, mid);
        } else {
            return firstBadVersion(mid+1, to);
        }
    }

    private boolean isBadVersion(int ver) {
        return ver >= 1702766719;
    }

    // 165. Compare Version Numbers
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

    // 8. String to Integer (atoi)
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        long sum = 0;
        Integer sign = null;
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - '0';
            if (sign == null && chars[i] == '-') {
                sign = -1;
            } else if (sign == null && chars[i] == '+') {
                sign = 1;
            } else if (val >= 0 && val <= 9) {
                sum = sum * 10;
                sum += val;
                if (sum > Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
            } else {
                // not valid after
                break;
            }
        }
        if (sign == null) {
            sign = 1;
        }
        if (sum < 0) {
            // overflow
            sum = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sign = 1;
        }
        return (int)sum * sign;
    }

    // 238. Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        // Given n > 1
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[n-i-1] = right[n-i] * nums[n-i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    // 319. Bulb Switcher
    public int bulbSwitch(int n) {
        int i = 1;
        while(i*i <= n) {
            i++;
        }
        return i-1;
    }

    // 79. Word Search
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;

        if (word == null || word.length() == 0) {
            return false;
        }
        char startChar = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == startChar) {
                    boolean[][] searchboard = new boolean[m][n];
                    if(search(board, word, i, j, 0, searchboard)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int x, int y, int wordIndex, boolean[][] searchboard) {
        int m = board.length;
        int n = board[0].length;

        if (board[x][y] != word.charAt(wordIndex)) {
            return false;
        }
        if(wordIndex >= word.length() - 1) {
            return true;
        }
        searchboard[x][y] = true;
        if (x-1 >= 0 && !searchboard[x-1][y]) {
            if(search(board, word, x-1, y, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (x+1 < m && !searchboard[x+1][y]) {
            if(search(board, word, x+1, y, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (y-1 >= 0 && !searchboard[x][y-1]) {
            if(search(board, word, x, y-1, wordIndex+1, searchboard)){
                return true;
            }
        }
        if (y+1 < n && !searchboard[x][y+1]) {
            if(search(board, word, x, y+1, wordIndex+1, searchboard)){
                return true;
            }
        }
        searchboard[x][y] = false;
        return false;
    }

    // 187. Repeated DNA Sequences
    private static int SEQ_LENGTH = 10;
    // Code the four letters: A:00, C:01, G:10, T:11
    private static Map<Character, Integer> dict = new HashMap<>();
    private static int mask = 0;
    static {
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);
        for (int i = 0; i < SEQ_LENGTH - 1; i++) {
            mask <<= 2;
            mask += 3;
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int codeLength = s.length() - SEQ_LENGTH + 1;
        if (codeLength<= 0) {
            return result;
        }
        int[] codes = new int[codeLength];
        // init codes[0]
        for (int i = 0; i < SEQ_LENGTH; i++) {
            codes[0] <<= 2;
            // Non-valid character will cause NullPointerException
            codes[0] += dict.get(s.charAt(i));
        }
        for (int i = 1; i < codeLength; i++) {
            int newCode = codes[i-1];
            newCode &= mask;
            newCode <<= 2;
            newCode += dict.get(s.charAt(i+SEQ_LENGTH-1));
            codes[i] = newCode;
        }
        Set<Integer> codeSeen = new HashSet<>();
        Set<String> seqs = new HashSet<>();
        for (int i = 0; i < codeLength; i++) {
            if (codeSeen.contains(codes[i])) {
                seqs.add(s.substring(i,i+SEQ_LENGTH));
            } else {
                codeSeen.add(codes[i]);
            }
        }
        result.addAll(seqs);
        return result;
    }

    // 137. Single Number II
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            recordBits(bits, nums[i]);
        }
        int number = 0;
        for (int i = 0; i < 32; i++) {
            number <<= 1;
            number += bits[31-i] % 3;
        }
        return number;
    }
    private void recordBits(int[] bits, int num) {
        for (int i = 0; i < 32; i++) {
            bits[i] += num & 1;
            num >>= 1;
        }
    }

    // 33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (nums[start] == nums[end]) {
            return target == nums[start] ? start : -1;
        } else if (nums[start] < nums[end]) {
            return searchSorted(nums, target, start, end);
        } else { // nums[start] > nums[end]
            int mid = (start + end) / 2;
            int left = search(nums, target, start, mid);
            if (left >= 0) {
                return left;
            }
            int right = search(nums, target, mid + 1, end);
            return right;
        }
    }

    private int searchSorted(int[] nums, int target, int start, int end) {
        if(target < nums[start] || target > nums[end]) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchSorted(nums, target, start, mid);
        } else { // target > nums[mid]
            return searchSorted(nums, target, mid + 1, end);
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        if ((long)numerator * (long)denominator < 0) {
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        num = (num % den) * 10;
        Map<Long, Integer> digits = new HashMap<>();
        Map<Integer, Long> reverseDigits = new HashMap<>();
        int i = 0;
        int j = -1;
        while (num > 0) {
            if (digits.containsKey(num)) {
                j = digits.get(num);
                break;
            }
            digits.put(num, i);
            long digit = num / den;
            reverseDigits.put(i, digit);
            i++;
            num = (num % den) * 10;
        }
        if (digits.size() > 0) {
            sb.append(".");
            if (j != -1) {
                for (int x = 0; x < j; x++) {
                    sb.append(reverseDigits.get(x));
                }
                sb.append("(");
                for (int x = j; x < reverseDigits.size(); x++) {
                    sb.append(reverseDigits.get(x));
                }
                sb.append(")");
            } else {
                for (int x = 0; x < reverseDigits.size(); x++) {
                    sb.append(reverseDigits.get(x));
                }
            }
        }
        return sb.toString();
    }
}